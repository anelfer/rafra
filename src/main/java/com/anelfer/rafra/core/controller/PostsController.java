package com.anelfer.rafra.core.controller;

import com.anelfer.rafra.core.Route;
import com.anelfer.rafra.core.model.PostsModel;
import com.anelfer.rafra.core.reader.mocking.FakeReader;
import com.anelfer.rafra.core.view.PostsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Route("/posts")
public class PostsController implements Controller {

    @Override
    public void executeGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PostsModel model = new PostsModel(FakeReader.instance);
        PostsView view = new PostsView(model);
        response.setContentType("text/html; charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(view.render("Тут посты", "style"));
        printWriter.close();
    }

    @Override
    public void executePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/posts");
        PostsModel model = new PostsModel(FakeReader.instance);
        request.setCharacterEncoding("UTF-8");
        model.addPost(request.getParameter("title"), request.getParameter("text"), request.getParameter("author"));
    }

}
