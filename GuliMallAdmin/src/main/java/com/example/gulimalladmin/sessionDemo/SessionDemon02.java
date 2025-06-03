package com.example.gulimalladmin.sessionDemo;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/s2")
@Slf4j
public class SessionDemon02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //从请求中得到session
        HttpSession session = req.getSession();

        //往session中添加数据
        String name = (String) session.getAttribute("name");
        log.info("name:"+session.getAttribute("name"));

        //得到session的ID
        String id = session.getId();

        //判断session是否为新创建的
        if (session.isNew()){
            resp.getWriter().write("session创建成功,sessionID为"+id);
        }else{
            resp.getWriter().write("session已经在服务器中存在，sessionID为："+id);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

