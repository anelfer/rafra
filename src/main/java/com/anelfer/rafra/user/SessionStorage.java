package com.anelfer.rafra.user;

import lombok.Getter;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;

@Getter
public class SessionStorage {

    private final List<SessionData> sessions = new ArrayList<>();

    public boolean containsByCookie(Cookie cookie) {
        return getSession(cookie) != null;
    }

    public SessionData getSession(Cookie cookie) {
        for (SessionData session : sessions) {
            if (session.getCookie().getName().equals(cookie.getName()) && session.getCookie().getValue().equals(cookie.getValue())) {
                return session;
            }
        }
        return null;
    }

}
