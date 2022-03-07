package com.anelfer.rafra.pages;

import com.anelfer.rafra.core.controller.MainController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="main",urlPatterns={""}, loadOnStartup = 1)
public class MainServlet extends HttpServlet {

    private final MainController controller = new MainController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        controller.executeGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        controller.executePost(req, resp);
    }

}
