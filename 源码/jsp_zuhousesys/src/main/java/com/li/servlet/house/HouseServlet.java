package com.li.servlet.house;

import com.li.domain.House;
import com.li.services.IHouseServices;
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
 * @ClassName: HouseServlet
 * @Description: ${description}
 * @Author: admin
 * @Create: 2022-04-24 13:25
 */
@WebServlet("/HouseServlet")
public class HouseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取排序方式
        String sort = request.getParameter("sort");
        IHouseServices services = new HouseServicesImpl();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");


        if ("desc".equals(sort)) {
            //按租金降序
            List<House> houses = services.sortHouses(-1);
            JSONArray js = JSONArray.fromObject(houses);
            response.getWriter().print(js);
        } else if ("asc".equals(sort)) {
            //按租金升序
            List<House> houses = services.sortHouses(1);
            JSONArray js = JSONArray.fromObject(houses);
            response.getWriter().print(js);
        } else if ("default".equals(sort)) {
            //按cname排序
            List<House> houses = services.sortHouses(0);
            JSONArray js = JSONArray.fromObject(houses);
            response.getWriter().print(js);
        }else{
            List<House> houses = services.sortHouses(0);
            request.setAttribute("houses",houses);
            request.getRequestDispatcher("house.jsp").forward(request, response);
        }

    }
}
