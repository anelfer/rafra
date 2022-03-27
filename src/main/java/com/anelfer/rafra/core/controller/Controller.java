package com.anelfer.rafra.core.controller;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Getter
@Setter
public abstract class Controller {

    private boolean logins = false;

    public void executeGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            PrintWriter printWriter = response.getWriter();
            printWriter.write(getHandler(request, response));
            printWriter.close();
        } catch (IOException e) {
            sendServerError(request, response);
        }
    }

    public void executePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        postHandler(request, response);
    }

    public String getHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "";
    }

    public void postHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    public void sendServerError(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/pages/500.jsp").forward(request, response);
        } catch (ServletException | IOException exception) {
            exception.printStackTrace();
        }
    }

}
