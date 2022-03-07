package com.anelfer.rafra.core.controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {

    void execute(HttpServletResponse response) throws IOException;

}
