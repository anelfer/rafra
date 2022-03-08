package com.anelfer.rafra.pages;

import com.anelfer.rafra.core.controller.PostController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="post",urlPatterns={"/post/*"})
public class PostServlet extends HttpServlet {

    private final PostController controller = new PostController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        controller.executeGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        controller.executePost(req, resp);
    }
}
