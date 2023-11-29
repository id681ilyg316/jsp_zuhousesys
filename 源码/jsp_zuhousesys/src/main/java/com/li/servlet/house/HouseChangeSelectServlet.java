package com.li.servlet.house;

import com.li.services.IHouseServices;
import com.li.services.impl.HouseServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Program: zuhousesys
 * @ClassName: HouseChangeSelectServlet
 * @Description: ${description}
 * @Author: admin
 * @Create: 2022-04-24 20:57
 */
@WebServlet("/HouseChangeSelectServlet")
public class HouseChangeSelectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _cids = request.getParameter("cids");
        int status = Integer.parseInt(request.getParameter("status"));

        System.out.println(status);

        IHouseServices services = new HouseServicesImpl();

        String[] ids = _cids.split(",");

        for (String id : ids) {
            services.changeHouseStatus(Integer.parseInt(id),status);
        }

        response.sendRedirect("PageHouseServlet");
    }
}
