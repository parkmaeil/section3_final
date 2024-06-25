package com.example.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateJson")
public class BookUpdateJsonController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // num -> req.getParameter("num")
        // json string을 받아서 ---Gson API--->BookDTO
        ServletInputStream sin =req.getInputStream();
        //  과제~~~
    }
}
