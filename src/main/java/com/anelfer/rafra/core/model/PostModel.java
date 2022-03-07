package com.anelfer.rafra.core.model;

import com.anelfer.rafra.core.reader.DataReader;
import com.anelfer.rafra.pages.Comment;
import com.anelfer.rafra.pages.Post;

import java.util.List;

public class PostModel implements Model {

    private final DataReader reader;

    public PostModel(DataReader reader) {
        this.reader = reader;
    }

    @Override
    public String getPage() {
        return "abobus";
    }

    @Override
    public void addPost(String title, String author, String text) {
        reader.addPost(new Post(title, author, text));
    }

    @Override
    public void addComment(String author, String text) {
        reader.addComment(new Comment(author, text));
    }

    @Override
    public List<Comment> getComments() {
        return reader.getComments();
    }

    @Override
    public List<Post> getPosts() {
        return reader.getPosts();
    }
}
