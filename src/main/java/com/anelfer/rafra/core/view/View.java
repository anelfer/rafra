package com.anelfer.rafra.core.view;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface View {

    void showContent(HttpServletResponse response, String content) throws IOException;

}
