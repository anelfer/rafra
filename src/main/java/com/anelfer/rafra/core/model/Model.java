package com.anelfer.rafra.core.model;

import com.anelfer.rafra.data.Comment;
import com.anelfer.rafra.data.Post;

import java.util.List;

public interface Model {

    String getPage();

    void addPost(String title, String author, String text);

    void addComment(String author, String text);

    List<Comment> getComments();

    List<Post> getPosts();

}
