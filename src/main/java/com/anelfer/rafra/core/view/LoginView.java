package com.anelfer.rafra.core.view;

public class LoginView extends PageView {

    @Override
    public String showContent() {
        return "<div class=\"home\">"+
                "<a href=\"/\" class=\"home_link\">Home</a>"+
                "</div>"+
                "<div class=\"wrapper\">" +
                "<form class=\"login\" action=\"/user_log\" method=\"post\">\n" +
                "  <input type=\"text\" placeholder=\"Username\" name=\"login\">\n" +
                "  <input type=\"password\" placeholder=\"Password\" name=\"pass\">\n" +
                "  <button>Login</button>\n" +
                "</form>\n" +
                "\n" +
                "<form class=\"register\" action=\"/user_reg\" method=\"post\">\n" +
                "  <input type=\"text\" placeholder=\"Username\" name=\"login\">\n" +
                "  <input type=\"text\" placeholder=\"E-mail\" name=\"email\">\n" +
                "  <input type=\"password\" placeholder=\"Password\" name=\"pass\">\n" +
                "  <input type=\"password\" placeholder=\"Repeat password\" name=\"repass\">\n" +
                "  <button>Register</button>\n" +
                "</form>\n" +
                "\n" +
                "</div>";
    }

}
