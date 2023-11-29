package com.li.servlet.house;

import com.li.domain.House;
import com.li.domain.PageBean;
import com.li.services.IHouseServices;
import com.li.services.impl.HouseServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Program: zuhousesys
 * @ClassName: PageHouseServlet
 * @Description: 分页加模糊查询House
 * @Author: admin
 * @Create: 2022-04-24 20:03
 */
@WebServlet("/PageHouseServlet")
public class PageHouseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();

        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        IHouseServices services = new HouseServicesImpl();

        if(currentPage == null){
            currentPage = "1";
        }

        if(pageSize == null){
            pageSize = "5";
        }

        PageBean<House> pageHouse = services.pageHouse(currentPage, pageSize,map);

        request.setAttribute("pu",pageHouse);
        request.setAttribute("mp",map);
        request.getRequestDispatcher("house-list.jsp").forward(request, response);
    }
}
