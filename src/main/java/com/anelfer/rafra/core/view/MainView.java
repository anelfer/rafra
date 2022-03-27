package com.anelfer.rafra.core.view;

import com.anelfer.rafra.AppConfig;
import com.anelfer.rafra.core.model.MainModel;
import lombok.AllArgsConstructor;

import javax.servlet.http.Cookie;

@AllArgsConstructor
public class MainView extends PageView {

    private final MainModel model;

    @Override
    public String showContent() {
        StringBuilder s = new StringBuilder("<div class=\"fm_wrapper\"><h1 class=\"fm_name\"> Rafra MVC Framework </h1></div>" +
                "<input type=\"checkbox\" id=\"ham-menu\">\n" +
                "<label for=\"ham-menu\">\n" +
                "  <div class=\"hide-des\">\n" +
                "    <span class=\"menu-line\"></span>\n" +
                "    <span class=\"menu-line\"></span>\n" +
                "    <span class=\"menu-line\"></span>\n" +
                "    <span class=\"menu-line\"></span>\n" +
                "    <span class=\"menu-line\"></span>\n" +
                "    <span class=\"menu-line\"></span>\n" +
                "  </div>\n" +
                "\n" +
                "</label>\n" +
                "<div class=\"full-page-green\"></div>\n");

        boolean login = false;
        for (Cookie cookie : model.getCookies()) {
            if (cookie.getName().equals("user") && AppConfig.sessionStorage.containsByCookie(cookie)) {
                s.append("<div class=\"login\">Hello, ").append(AppConfig.sessionStorage.getSession(cookie).getUser().getName()).append("</div>");
                login = true;
                break;
            }
        }

        if (!login) {
            s.append("<a href=\"login\" class=\"login\">Login/Register</a>");
        }

        s.append("<div class=\"ham-menu\">\n" +
                "  <ul class=\"centre-text bold-text\">\n" +
                "    <li><a href=\"posts\">Posts</a></li>\n" +
                "    <li><a href=\"comments\">Comments</a></li>\n" +
                "\n" +
                "  </ul>\n" +
                "</div>");
        return s.toString();
    }

}
