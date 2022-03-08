package com.anelfer.rafra.core.model;

import com.anelfer.rafra.core.reader.DataReader;
import com.anelfer.rafra.data.Comment;
import com.anelfer.rafra.data.Post;

import java.util.List;

public class PostModel extends Model {

    private final DataReader reader;
    private final int postId;

    public PostModel(DataReader instance, int id) {
        this.reader = instance;
        this.postId = id;
    }

    public Post getPost() {
        return reader.getPost(postId);
    }

    public void addComment(String author, String text) {
        reader.addComment(new Comment(author, text));
    }

    public List<Comment> getComments() {
        return reader.getComments();
    }

}
