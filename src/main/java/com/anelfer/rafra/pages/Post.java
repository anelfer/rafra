package com.anelfer.rafra.pages;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {

    private String title;
    private String author;
    private String text;
    private int views;

    public Post(String title, String author, String text) {
        this.title = title;
        this.author = author;
        this.text = text;
    }
}
