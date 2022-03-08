package com.anelfer.rafra.core.model;

import com.anelfer.rafra.core.reader.DataReader;
import com.anelfer.rafra.data.Post;

import java.util.List;

public class PostsModel extends Model {

    private final DataReader reader;

    public PostsModel(DataReader reader) {
        this.reader = reader;
    }

    public void addPost(String title, String author, String text) {
        reader.addPost(new Post(title, author, text));
    }

    public List<Post> getPosts() {
        return reader.getPosts();
    }
}
