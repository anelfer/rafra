package com.anelfer.rafra.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.Cookie;

@AllArgsConstructor
@Getter
public class MainModel extends Model {

    private final Cookie[] cookies;

}
