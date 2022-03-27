package com.anelfer.rafra.core.controller.login;

import com.anelfer.rafra.core.Route;
import com.anelfer.rafra.core.controller.Controller;
import com.anelfer.rafra.core.view.LoginView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Route("/login")
public class LoginController extends Controller {

    @Override
    public String getHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LoginView loginView = new LoginView();
        return loginView.render("Login", "login");
    }
}
