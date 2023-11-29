package com.li.servlet.house;

import com.li.dao.impl.HouseDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Program: zuhousesys
 * @ClassName: HouseChangeStatusServlet
 * @Description: ${description}
 * @Author: admin
 * @Create: 2022-04-24 20:46
 */
@WebServlet("/HouseChangeStatusServlet")
public class HouseChangeStatusServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        int status = Integer.parseInt(request.getParameter("status"));

        new HouseDaoImpl().changeHouseStatus(Integer.parseInt(cid),-status);
    }
}
