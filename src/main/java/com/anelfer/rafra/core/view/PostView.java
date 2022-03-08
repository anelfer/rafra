package com.anelfer.rafra.core.view;

import com.anelfer.rafra.core.model.PostModel;
import com.anelfer.rafra.data.Post;

public class PostView extends PageView {

    private final PostModel model;

    public PostView(PostModel model) {
        this.model = model;
    }

    @Override
    public String showContent() {
        StringBuilder builder = new StringBuilder();
        Post post = model.getPost();
        builder.append("<h1>").append(post.getTitle()).append("</h1>");
        builder.append("<div class=\"post\">\n");
        builder.append("<p>").append(post.getText()).append("</p>\n");
        builder.append("<p>").append(post.getAuthor()).append("</p>\n");
        builder.append("<p>").append(post.getId()).append("</p>\n");
        builder.append("</div>");
        builder.append("<a href=\"/posts\"><div class=\"arrow\">\n" +
                "  <div class=\"arrow-top\"></div>\n" +
                "  <div class=\"arrow-bottom\"></div>\n" +
                "</div></a>");
        return builder.toString();
    }
}
