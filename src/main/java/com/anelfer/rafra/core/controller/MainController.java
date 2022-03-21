package com.anelfer.rafra.core.controller;

import com.anelfer.rafra.core.Route;
import com.anelfer.rafra.core.view.MainView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Route()
public class MainController extends Controller {

    @Override
    public String getHandler(HttpServletRequest request, HttpServletResponse response) {
        MainView view = new MainView();
        return view.render("Rafra", "main");
    }

}
