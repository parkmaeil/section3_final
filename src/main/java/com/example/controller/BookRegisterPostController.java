package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookDAOMyBatis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

@WebServlet("/registerPost")
public class BookRegisterPostController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //파라메터 수집(DTO) ->  Spring 자동으로 해준다.
            req.setCharacterEncoding("utf-8");
            String title=req.getParameter("title");
            int price=Integer.parseInt(req.getParameter("price"));
            String author=req.getParameter("author");
            int page=Integer.parseInt(req.getParameter("page"));
            BookDTO dto=new BookDTO(title, price, author, page);

           BookDAOMyBatis dao=new BookDAOMyBatis();
           int cnt=dao.bookRegister(dto);
          if(cnt > 0){
            // 성공 -> 다시 리스트~~
            //resp.sendRedirect("/s3_f/list");
              PrintWriter out=resp.getWriter();
              out.println("success"); // Postmain으로 성공여부를 전달...
         }else{
            throw new ServletException("삭제실패");
        }
    }
}
