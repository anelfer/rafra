package com.anelfer.rafra.core.controller;

import com.anelfer.rafra.core.Route;
import com.anelfer.rafra.core.model.PostModel;
import com.anelfer.rafra.core.reader.mocking.FakeReader;
import com.anelfer.rafra.core.view.PostView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Route("/post/.*")
public class PostController implements Controller {

    @Override
    public void executeGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] split = request.getRequestURI().split("/");
        if (split.length < 3) {
            response.sendRedirect("/posts");
            return;
        }
        int id = Integer.parseInt(split[2]);
        PostModel model = new PostModel(FakeReader.instance, id);
        PostView view = new PostView(model);
        response.setContentType("text/html; charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(view.render("Пост №" + id, "post"));
        printWriter.close();
    }

    @Override
    public void executePost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
