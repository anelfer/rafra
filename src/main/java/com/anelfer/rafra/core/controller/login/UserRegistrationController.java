package com.anelfer.rafra.core.controller.login;

import com.anelfer.rafra.AppConfig;
import com.anelfer.rafra.core.Route;
import com.anelfer.rafra.core.controller.Controller;
import com.anelfer.rafra.core.dao.UserDao;
import com.anelfer.rafra.core.model.UserModel;
import com.anelfer.rafra.user.SessionData;
import com.anelfer.rafra.utils.AppUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.Locale;

@Route("/user_reg")
public class UserRegistrationController extends Controller {

    @Override
    public void postHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            UserDao userDao = AppConfig.userDao;
            String login = request.getParameter("login");
            String pass = request.getParameter("pass");
            String repass = request.getParameter("repass");
            String email = request.getParameter("email");

            if (pass.equals(repass) && !userDao.containsUser(login)) {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                md5.update(pass.getBytes());
                byte[] digest = md5.digest();
                String s = DatatypeConverter.printHexBinary(digest).toUpperCase(Locale.ROOT);

                md5.update(login.getBytes());
                Cookie user = new Cookie("user", s + DatatypeConverter.printHexBinary(md5.digest()).toUpperCase(Locale.ROOT));
                user.setMaxAge(120);
                response.addCookie(user);
                UserModel userModel = new UserModel(login, email, s);
                AppConfig.sessionStorage.getSessions().add(new SessionData(user, userModel, System.currentTimeMillis()));
                response.sendRedirect("/");
            } else {
                AppUtils.sendMessage(response, "Passwords don't match or user with this name already exists!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            sendServerError(request, response);
        }
    }
}
