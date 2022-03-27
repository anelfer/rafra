package com.anelfer.rafra.core;

import com.anelfer.rafra.AppConfig;
import com.anelfer.rafra.core.controller.Controller;
import com.anelfer.rafra.utils.AppUtils;
import org.reflections.Reflections;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
                Route annotation = aClass.getAnnotation(Route.class);
                Controller controller = (Controller) aClass.getConstructor().newInstance();
                controller.setLogins(annotation.auth());
                controllers.put(annotation.value(), controller);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void get(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws IOException, ServletException {
        String requestURI = req.getRequestURI();
        if (controllers.containsKey(replacePattern(requestURI))) {
            Controller controller = controllers.get(replacePattern(requestURI));
            if (controller.isLogins() && checkAuth(req, resp)) {
                controller.executeGet(req, resp);
            } else if (controller.isLogins() && !checkAuth(req, resp)) {
                AppUtils.sendMessage(resp, "Only for logged user!");
            } else {
                controller.executeGet(req, resp);
            }
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
            checkAuth(req, resp);
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

    private boolean checkAuth(HttpServletRequest req, HttpServletResponse resp) {
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("user") && !AppConfig.sessionStorage.containsByCookie(cookie)) {
                cookie.setMaxAge(-1);
                resp.addCookie(cookie);
                return false;
            } else if (cookie.getName().equals("user") && AppConfig.sessionStorage.containsByCookie(cookie)) {
                return true;
            }
        }
        return false;
    }

}
