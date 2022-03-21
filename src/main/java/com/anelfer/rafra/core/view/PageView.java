package com.anelfer.rafra.core.view;

public abstract class PageView {

    public String render(String title, String css) {
        return "<!DOCTYPE html> <html>" + renderHead(title, css) + "<body>" + showContent() + renderFooter() + "</body></html>";
    }

    public String renderHead(String title, String css) {
        return "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<title>" + title + "</title>" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/" + css + ".css\">" +
                "</head>";
    }

    public String renderFooter() {
        return "<footer></footer>";
    }

    public abstract String showContent();

}
