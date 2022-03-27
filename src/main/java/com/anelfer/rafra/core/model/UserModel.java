package com.anelfer.rafra.core.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel extends Model {

    private static int idCounter = 1;
    private int id;
    private String name;
    private String email;
    private String passHash;

    public UserModel(String name, String email, String passHash) {
        this.id = idCounter++;
        this.name = name;
        this.email = email;
        this.passHash = passHash;
    }

}
