package com.anelfer.rafra.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {

    private static int idCounter = 1;
    private int id;
    private String title;
    private String author;
    private String text;
    private int views;

    public Post(String title, String author, String text) {
        this.id = idCounter++;
        this.title = title;
        this.author = author;
        this.text = text;
    }
}
