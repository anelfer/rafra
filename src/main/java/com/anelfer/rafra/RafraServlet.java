package com.anelfer.rafra;

import com.anelfer.rafra.core.controller.HomeController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class RafraServlet extends HttpServlet {

    private final HomeController controller = new HomeController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        controller.execute(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

    }

}
