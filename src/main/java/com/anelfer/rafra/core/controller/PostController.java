package com.anelfer.rafra.core.controller;

import com.anelfer.rafra.AppConfig;
import com.anelfer.rafra.core.Route;
import com.anelfer.rafra.core.view.PostView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Route("/post/.*")
public class PostController extends Controller {

    @Override
    public String getHandler(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] split = req.getRequestURI().split("/");
        if (split.length < 3) {
            resp.sendRedirect("/posts");
            return "";
        }

        try {
            int id = Integer.parseInt(split[2]);
            PostView view = new PostView(AppConfig.postDao.get(id));
            return view.render("Пост №" + id, "post");
        } catch (Exception e) {
            sendServerError(req, resp);
        }
        return "";
    }

}
