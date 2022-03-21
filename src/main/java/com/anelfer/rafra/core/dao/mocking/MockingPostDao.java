package com.anelfer.rafra.core.dao.mocking;

import com.anelfer.rafra.core.dao.PostDao;
import com.anelfer.rafra.core.model.PostModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MockingPostDao extends PostDao {

    private final List<PostModel> posts = new ArrayList<>();

    public MockingPostDao() {
        posts.add(new PostModel("Абоба", "pupkin", "тут текстsdfsfv"));
        posts.add(new PostModel("Абоба2", "add", "тут текстfdf"));
        posts.add(new PostModel("Абоба5", "sheesh", "тут текст21"));
        posts.add(new PostModel("Абоба69", "puks", "тут текст1"));
    }

    @Override
    public PostModel get(int id) {
        return posts.stream().filter(post -> post.getId() == id).collect(Collectors.toList()).get(0);
    }

    @Override
    public List<PostModel> getAll() {
        return posts;
    }

    @Override
    public void add(PostModel post) {
        posts.add(post);
    }

}
