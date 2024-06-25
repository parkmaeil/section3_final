package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookDAOMyBatis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update")
public class BookUpdateController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. form에서 전달된 파라메터를 받기
        // 2. String으로(JSON)으로 데이터를 전달하기

        req.setCharacterEncoding("utf-8");
        int reqNum=Integer.parseInt(req.getParameter("num"));
        String title=req.getParameter("title");
        int price=Integer.parseInt(req.getParameter("price"));
        String author=req.getParameter("author");
        int page=Integer.parseInt(req.getParameter("page"));

        BookDTO dto=new BookDTO(title, price, author, page);

        BookDAOMyBatis dao=new BookDAOMyBatis();
        int cnt=dao.bookUpdate(reqNum, dto);

        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter out =resp.getWriter(); // Stream(출력)
        if(cnt>0) {
              out.println("성공");
        }else{
              out.println("실패");
        }
    }
}
