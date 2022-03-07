package com.anelfer.rafra.pages;

import com.anelfer.rafra.core.controller.PostController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/comments")
public class CommentServlet extends HttpServlet {

    private final PostController controller = new PostController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        controller.executeGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        controller.executePost(req, resp);
    }

}