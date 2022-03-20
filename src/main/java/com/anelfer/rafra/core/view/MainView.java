package com.anelfer.rafra.core.view;

public class MainView extends PageView {

    @Override
    public String showContent() {
        return "<div class=\"fm_wrapper\"><h1 class=\"fm_name\"> Rafra MVC Framework </h1></div>" +
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
                "<div class=\"full-page-green\"></div>\n" +
                "<div class=\"ham-menu\">\n" +
                "  <ul class=\"centre-text bold-text\">\n" +
                "    <li><a href=\"posts\">Posts</a></li>\n" +
                "    <li><a href=\"comments\">Comments</a></li>\n" +
                "\n" +
                "  </ul>\n" +
                "</div>";
    }
}
