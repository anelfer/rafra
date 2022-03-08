package com.anelfer.rafra.core.view;

import com.anelfer.rafra.core.model.PostsModel;
import com.anelfer.rafra.data.Post;

public class PostsView extends PageView {

    private final PostsModel model;

    public PostsView(PostsModel model) {
        this.model = model;
    }

    @Override
    public String showContent() {
        StringBuilder builder = new StringBuilder();
        builder.append("<div class=\"header\"><p>Это типо посты</p>");
        builder.append("<a href=\"/\" class=\"button\">Home</a></div><div class=\"block\"><div class=\"posts\">");
        for (Post post : model.getPosts()) {
            builder.append("<a href=\"/post/").append(post.getId()).append("\">");
            builder.append("<div class=\"post\">\n");
            builder.append("<h1 class=\"title\">").append(post.getTitle()).append("</h1>\n");
            builder.append("<p>").append(post.getText()).append("</p>\n");
            builder.append("<p>").append(post.getAuthor()).append("</p>\n");
            builder.append("<p>").append(post.getId()).append("</p>\n");
            builder.append("</div></a>\n");
        }
        builder.append("</div>");
        builder.append("<form class=\"form_post\" action=\"/posts\" method=\"post\">\n" +
                "    <input type=\"text\" name=\"title\" value=\"John\"><br><br>\n" +
                "    <input type=\"text\" name=\"text\" value=\"John\"><br><br>\n" +
                "    <input type=\"text\" name=\"author\" value=\"John\"><br><br>\n" +
                "    <input type=\"submit\" value=\"Submit\">\n" +
                "</form></div>");
        return builder.toString();
    }
}
