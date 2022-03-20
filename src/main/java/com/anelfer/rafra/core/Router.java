package com.anelfer.rafra.core;

import com.anelfer.rafra.core.controller.Controller;
import org.reflections.Reflections;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Router {

    private final Map<String, Controller> controllers = new HashMap<>();

    public Router() {
        Reflections reflections = new Reflections("com.anelfer.rafra.core.controller");
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(Route.class);
        for (Class<?> aClass : typesAnnotatedWith) {
            try {
                controllers.put(aClass.getAnnotation(Route.class).value(), (Controller) aClass.getConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void get(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws IOException, ServletException {
        String requestURI = req.getRequestURI();
        if (controllers.containsKey(replacePattern(requestURI))) {
            controllers.get(replacePattern(requestURI)).executeGet(req, resp);
        } else {
            if (requestURI.endsWith(".css") || requestURI.endsWith(".js")) {
                try {
                    InputStream resourceAsStream = servletContext.getResourceAsStream(requestURI);
                    PrintWriter writer = resp.getWriter();
                    Scanner scanner = new Scanner(resourceAsStream);
                    StringBuilder data = new StringBuilder();
                    while (scanner.hasNext()) {
                        data.append(scanner.next()).append("\n");
                    }
                    writer.write(data.toString());
                    resourceAsStream.close();
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                req.getRequestDispatcher("/pages/404.jsp").forward(req, resp);
            }
        }
    }

    public void post(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String requestURI = req.getRequestURI();
        if (controllers.containsKey(requestURI)) {
            controllers.get(requestURI).executePost(req, resp);
        } else {
            if (requestURI.endsWith(".css") || requestURI.endsWith(".js")) {
                req.getRequestDispatcher(requestURI).forward(req, resp);
            } else {
                req.getRequestDispatcher("/pages/404.jsp").forward(req, resp);
            }
        }
    }

    private String replacePattern(String path) {
        for (String s : controllers.keySet()) {
            if (!s.contains("*")) continue;
            return path.replaceAll(s, s);
        }
        return "";
    }

}
