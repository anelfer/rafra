package com.anelfer.rafra.core.controller;

import com.anelfer.rafra.core.model.PostModel;
import com.anelfer.rafra.core.reader.mocking.FakeReader;
import com.anelfer.rafra.core.view.PostsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PostController implements Controller {

    private final FakeReader reader = new FakeReader();

    @Override
    public void executeGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PostModel model = new PostModel(reader);
        PostsView view = new PostsView(model);
        response.setContentType("text/html; charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(view.render("Тут посты"));
        printWriter.close();
    }

    @Override
    public void executePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/h");
        PostModel model = new PostModel(reader);
        model.addPost(request.getParameter("title"), request.getParameter("text"), request.getParameter("author"));
    }

}
