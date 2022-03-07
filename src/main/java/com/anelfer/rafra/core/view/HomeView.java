package com.anelfer.rafra.core.view;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HomeView implements View {

    @Override
    public void showContent(HttpServletResponse response, String content) throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(content);
        printWriter.close();
    }
}
