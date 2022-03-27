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
import java.security.MessageDigest;
import java.util.Locale;

@Route("/user_log")
public class UserLoginController extends Controller {

    @Override
    public void postHandler(HttpServletRequest request, HttpServletResponse response) {
        try {
            UserDao userDao = AppConfig.userDao;
            String login = request.getParameter("login");
            String pass = request.getParameter("pass");

            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(pass.getBytes());
            byte[] digest = md5.digest();
            String s = DatatypeConverter.printHexBinary(digest).toUpperCase(Locale.ROOT);

            if (userDao.containsUser(login)) {
                UserModel user = userDao.getByLogin(login);
                if (user.getPassHash().equals(s)) {
                    md5.update(user.getName().getBytes());
                    Cookie cookie = new Cookie("user", s + DatatypeConverter.printHexBinary(md5.digest()).toUpperCase(Locale.ROOT));
                    cookie.setMaxAge(120);
                    response.addCookie(cookie);
                    AppConfig.sessionStorage.getSessions().add(new SessionData(cookie, user, System.currentTimeMillis()));
                    response.sendRedirect("/");
                } else {
                    AppUtils.sendMessage(response, "Login or password incorrect!");
                }
            } else {
                AppUtils.sendMessage(response, "This user is not registration!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            sendServerError(request, response);
        }
    }
}
