package com.anelfer.rafra.core.reader;

import com.anelfer.rafra.pages.Comment;
import com.anelfer.rafra.pages.Post;

import java.util.List;

public interface DataReader {

    List<Comment> getComments();

    List<Post> getPosts();

    void addPost(Post post);

    void addComment(Comment comment);

}
