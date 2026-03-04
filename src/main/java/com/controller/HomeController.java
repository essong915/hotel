package com.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HomeController implements Action {

    public String execute(HttpServletRequest request,
                          HttpServletResponse response) {
        request.setAttribute("pageTitle", "Vinst Hotel");
        request.setAttribute("pageCss", "home_main");
        
        request.setAttribute("contentPage",
                "/WEB-INF/views/home/main.jsp");

        return "home/main";
    }
}

