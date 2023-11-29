package com.li.servlet.house;

import com.li.domain.House;
import com.li.services.impl.HouseServicesImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Program: zuhousesys
 * @ClassName: HouseSearchServlet
 * @Description: 民宿屋模糊查询
 * @Author: admin
 * @Create: 2022-04-24 14:17
 */
@WebServlet("/HouseSearchServlet")
public class HouseSearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cname = request.getParameter("cname");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        List<House> houses = new HouseServicesImpl().fuzzyQueryByHouse(cname);
        JSONArray js = JSONArray.fromObject(houses);

        response.getWriter().print(js);
    }
}
