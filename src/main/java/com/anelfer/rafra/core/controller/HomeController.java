package com.anelfer.rafra.core.controller;

import com.anelfer.rafra.core.model.HomeModel;
import com.anelfer.rafra.core.view.HomeView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeController implements Controller {

    private final HomeModel model = new HomeModel();
    private final HomeView view = new HomeView();

    @Override
    public void execute(HttpServletResponse response) throws IOException {
        view.showContent(response, model.getPage());
    }
}
