package com.anelfer.rafra.core.controller;

import com.anelfer.rafra.core.view.MainView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainController implements Controller {

    @Override
    public void executeGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MainView view = new MainView();
        response.setContentType("text/html; charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(view.render("Rafra", "main"));
        printWriter.close();
    }

    @Override
    public void executePost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
