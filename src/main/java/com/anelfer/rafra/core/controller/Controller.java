package com.anelfer.rafra.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {

    void executeGet(HttpServletRequest request, HttpServletResponse response) throws IOException;

    void executePost(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
