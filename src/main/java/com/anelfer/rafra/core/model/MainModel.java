package com.anelfer.rafra.core.model;

import com.anelfer.rafra.data.Comment;
import com.anelfer.rafra.data.Post;

import java.util.List;

public class MainModel implements Model {
    @Override
    public String getPage() {
        return null;
    }

    @Override
    public void addPost(String title, String author, String text) {

    }

    @Override
    public void addComment(String author, String text) {

    }

    @Override
    public List<Comment> getComments() {
        return null;
    }

    @Override
    public List<Post> getPosts() {
        return null;
    }
}
