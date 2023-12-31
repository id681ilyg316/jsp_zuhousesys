package com.li.servlet.house;

import com.li.domain.Order;
import com.li.services.IOrderServices;
import com.li.services.impl.OrderServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Program: zuhousesys
 * @ClassName: OrderPageServlet
 * @Description: 用户查看自己的订单
 * @Author: admin
 * @Create: 2022-04-24 17:03
 */
@WebServlet("/OrderPageServlet")
public class OrderPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IOrderServices services = new OrderServicesImpl();
        String email = (String)request.getSession().getAttribute("email");
        String status = request.getParameter("status");

        List<Order> orders = services.queryOrderByEmail(email,Integer.parseInt(status));

        request.setAttribute("list", orders);
        request.getRequestDispatcher("uorder.jsp").forward(request, response);
    }
}
