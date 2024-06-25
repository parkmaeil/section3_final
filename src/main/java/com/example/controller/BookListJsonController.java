package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookDAOMyBatis;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
// Rest Open URL
// http://localhost:8081/s3_final/listJson : key발급(JWT)
@WebServlet("/listJson")
public class BookListJsonController extends HttpServlet { // POJO
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
                                                           throws ServletException, IOException {
        //BookDAO dao=new BookDAO();
        //Model과연동하는 부분
        BookDAOMyBatis dao=new BookDAOMyBatis();

        List<BookDTO> list=dao.bookList(); // Gson API

        Gson g=new Gson();
        String json=g.toJson(list); // [ {    }, {    }, {     }.....     ]
        // View X
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out =resp.getWriter(); // Stream(출력)
        out.println(json); // JSON형태를 응답해주는 컨트롤러=>RestController
    }
}
