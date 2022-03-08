package com.anelfer.rafra.core.reader;

import com.anelfer.rafra.data.Comment;
import com.anelfer.rafra.data.Post;

import java.util.List;

public interface DataReader {

    List<Comment> getComments();

    List<Post> getPosts();

    Post getPost(int id);

    void addPost(Post post);

    void addComment(Comment comment);

}
