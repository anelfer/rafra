package com.anelfer.rafra.core.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentModel extends Model {

    private String author;
    private String text;

    public CommentModel(String author, String text) {
        this.author = author;
        this.text = text;
    }

}
