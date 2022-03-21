package com.anelfer.rafra.core.controller;

import com.anelfer.rafra.AppConfig;
import com.anelfer.rafra.core.Route;
import com.anelfer.rafra.core.model.PostModel;
import com.anelfer.rafra.core.model.PostsModel;
import com.anelfer.rafra.core.view.PostsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Route("/posts")
public class PostsController extends Controller {

    @Override
    public String getHandler(HttpServletRequest request, HttpServletResponse response) {
        PostsModel model = new PostsModel();
        PostsView view = new PostsView(model);
        return view.render("Тут посты", "style");
    }

    @Override
    public void postHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/posts");
        AppConfig.postDao.add(
                new PostModel(request.getParameter("title"), request.getParameter("text"), request.getParameter("author")));
    }

}
