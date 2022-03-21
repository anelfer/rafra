package com.anelfer.rafra.core.model;

import com.anelfer.rafra.AppConfig;

import java.util.ArrayList;
import java.util.List;

public class PostsModel extends Model {

    private final List<PostModel> posts = new ArrayList<>();

    public PostsModel() {
        posts.addAll(AppConfig.postDao.getAll());
    }

    public List<PostModel> getPosts() {
        return posts;
    }

}
