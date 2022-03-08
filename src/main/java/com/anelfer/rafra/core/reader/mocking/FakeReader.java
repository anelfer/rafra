package com.anelfer.rafra.core.reader.mocking;

import com.anelfer.rafra.core.reader.DataReader;
import com.anelfer.rafra.data.Comment;
import com.anelfer.rafra.data.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FakeReader implements DataReader {

    public static FakeReader instance = new FakeReader();
    private final List<Comment> comments = new ArrayList<>();
    private final List<Post> posts = new ArrayList<>();

    public FakeReader() {
        posts.add(new Post("Абоба", "pupkin", "тут текстsdfsfv"));
        posts.add(new Post("Абоба2", "add", "тут текстfdf"));
        posts.add(new Post("Абоба5", "sheesh", "тут текст21"));
        posts.add(new Post("Абоба69", "puks", "тут текст1"));
    }

    @Override
    public List<Comment> getComments() {
        return this.comments;
    }

    @Override
    public List<Post> getPosts() {
        return this.posts;
    }

    @Override
    public Post getPost(int id) {
        return posts.stream().filter(post -> post.getId() == id).collect(Collectors.toList()).get(0);
    }

    @Override
    public void addPost(Post post) {
        posts.add(post);
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
