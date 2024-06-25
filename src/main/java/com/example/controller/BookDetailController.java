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

@WebServlet("/detail") // /s3_final/detail?num=1
public class BookDetailController extends HttpServlet { // Servlet

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
                                                                              throws ServletException, IOException {
          int reqNum=Integer.parseInt(req.getParameter("num"));
          // DAO(Model) 연동
        BookDAOMyBatis dao=new BookDAOMyBatis();
        BookDTO model=dao.bootDetail(reqNum);
        System.out.println(model);
        // 1. 바로 model(Data)을 응답해준다.(View) -> JSON
        // 2.  JSP로 forward(포워딩)
        //req.setAttribute("book", model);
        //RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/views/detail.jsp");
        //rd.forward(req, resp);
        // 10시35분~~~
        Gson g=new Gson();
        String json=g.toJson(model); //  { "num":10, "title":"1111", "price":1111, "author":"1111", "page":1111  }
        // 응답 -> 응답하는 데이터의 타입정보(MIME Type)를 클라이언트에게 알려주기
        // 1. html, text, xml, json
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out =resp.getWriter(); // Stream(출력)
        out.println(json); //BookDTO(num=10, title=1111, price=1111, author=1111, page=1111)
        // XML, JSON(O) -> { "num":10, "title":"1111", "price":1111, "author":"1111", "page":1111  }
        // Object(DTO)<-- ?(API)-->JSON : Gson API
    }
}
/*
 [
   { "num":10, "title":"1111", "price":1111, "author":"1111", "page":1111  },
   { "num":10, "title":"1111", "price":1111, "author":"1111", "page":1111  },
   { "num":10, "title":"1111", "price":1111, "author":"1111", "page":1111  }
   ]
 */