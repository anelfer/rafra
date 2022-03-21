package com.anelfer.rafra.core.view;

import com.anelfer.rafra.core.model.PostModel;

public class PostView extends PageView {

    private final PostModel model;

    public PostView(PostModel model) {
        this.model = model;
    }

    @Override
    public String showContent() {
        return "<h1>" + model.getTitle() + "</h1>" +
                "<div class=\"post\">\n" +
                "<p>" + model.getText() + "</p>\n" +
                "<p>" + model.getAuthor() + "</p>\n" +
                "<p>" + model.getId() + "</p>\n" +
                "</div>" +
                "<a href=\"/posts\"><div class=\"arrow\">\n" +
                "  <div class=\"arrow-top\"></div>\n" +
                "  <div class=\"arrow-bottom\"></div>\n" +
                "</div></a>";
    }

}
