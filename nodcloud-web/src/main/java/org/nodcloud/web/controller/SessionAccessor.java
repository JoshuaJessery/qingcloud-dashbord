package org.nodcloud.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionAccessor {

    private HttpSession session;

    public SessionAccessor(HttpServletRequest request) {
        this.session = request.getSession();
    }

    public void addFlashAttribute(String name, Object attribute) {
        put(name, attribute);
    }

    private void put(String name, Object attribute) {
        this.session.setAttribute(name, attribute);
    }

}
