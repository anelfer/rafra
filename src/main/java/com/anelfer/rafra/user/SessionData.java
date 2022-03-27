package com.anelfer.rafra.user;

import com.anelfer.rafra.core.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.Cookie;

@AllArgsConstructor
@Getter
public class SessionData {

    private final Cookie cookie;
    private final UserModel user;
    private final long timestamp;

}
