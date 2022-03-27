package com.anelfer.rafra.utils;

import lombok.experimental.UtilityClass;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@UtilityClass
public class AppUtils {

    public void sendMessage(HttpServletResponse resp, String message) throws IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(message);
        writer.close();
    }

}
