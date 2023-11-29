package com.li.servlet.house;

import com.li.domain.House;
import com.li.services.IHouseServices;
import com.li.services.impl.HouseServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Program: zuhousesys
 * @ClassName: OrderServlet
 * @Description: 民宿屋订单页面
 * @Author: admin
 * @Create: 2022-04-24 15:45
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");

        IHouseServices services = new HouseServicesImpl();
        House house = services.queryHouseById(Integer.parseInt(cid));

        //看房时间加30天
        Calendar ca = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String takeTime = formatter.format(new Date());

        ca.add(Calendar.DATE,3);

        String getTime = formatter.format(ca.getTime());

        request.setAttribute("house", house);
        request.setAttribute("takeTime", takeTime);
        request.setAttribute("getTime", getTime);
        request.getRequestDispatcher("user-order.jsp").forward(request,response);

    }
}
