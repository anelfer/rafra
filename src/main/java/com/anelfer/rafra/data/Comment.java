package com.anelfer.rafra.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {

    private String author;
    private String text;

    public Comment(String author, String text) {
        this.author = author;
        this.text = text;
    }
}
