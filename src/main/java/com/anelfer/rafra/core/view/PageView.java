package com.anelfer.rafra.core.view;

public abstract class PageView {

    public String render(String title) {
        return "<!DOCTYPE html> <html>" + renderHead(title) + "<body>" + showContent() + renderFooter() + "</body></html>";
    }

    public String renderHead(String title) {
        return "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<title>" + title + "</title>" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/style.css\">" +
                "</head>";
    }

    public String renderFooter() {
        return "<footer></footer>";
    }

    public abstract String showContent();
}
