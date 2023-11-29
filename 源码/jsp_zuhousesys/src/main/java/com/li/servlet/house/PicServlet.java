package com.li.servlet.house;

import com.li.domain.House;
import com.li.services.IHouseServices;
import com.li.services.impl.HouseServicesImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Program: zuhousesys
 * @ClassName: PicServlet
 * @Description: 文件上传
 * @Author: admin
 * @Create: 2022-04-24 21:18
 */
@WebServlet("/PicServlet")
public class PicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (ServletFileUpload.isMultipartContent(request)) {
            ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());

            String name = null;
            double rent = -1.0;
            int status = -10;
            String houseInfo = null;
            String imgPath = null;

            try {
                List<FileItem> items = sf.parseRequest(request);
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        if ("cname".equals(item.getFieldName())) {
                            name = item.getString("utf-8");
                        } else if ("crent".equals(item.getFieldName())) {
                            rent = Double.parseDouble(item.getString());
                        } else if ("status".equals(item.getFieldName())) {
                            status = Integer.parseInt(item.getString());
                        } else if ("cinfo".equals(item.getFieldName())) {
                            houseInfo = item.getString("utf-8");
                        }
                    } else {
                        String fileName = name + ".jpg";
                        //绝对路径
                        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(0,Thread.currentThread().getContextClassLoader().getResource("").getPath().length()-16)+"/images";
                        File file = new File(path, fileName);
                        item.write(file);
                        imgPath = "images/" + fileName;
                    }
                }

                House house = new House(imgPath, houseInfo, name, rent, status);
                IHouseServices ics = new HouseServicesImpl();
                ics.addHouse(house);

            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                response.sendRedirect("house-add.html");
            }

        }
    }
}
