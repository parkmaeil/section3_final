package com.example.controller;

import com.example.repository.BookDAOMyBatis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete") // 전처리를 하라는 기능
public class BookDeleteController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
                                                           throws ServletException, IOException {
                    // ?num=1
                    int reqNum=Integer.parseInt(req.getParameter("num")); // "111"->111
                    BookDAOMyBatis dao=new BookDAOMyBatis();
                    int cnt=dao.bookDelete(reqNum);
                    if(cnt > 0){
                        // 성공 -> 다시 리스트~~
                        resp.sendRedirect("/s3_f/list");
                    }else{
                        throw new ServletException("삭제실패");
                    }
    }
}
