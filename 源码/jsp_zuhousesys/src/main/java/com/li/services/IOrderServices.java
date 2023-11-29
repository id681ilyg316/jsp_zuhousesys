package com.li.services;

import com.li.domain.Order;
import com.li.domain.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Program: zuhousesys
 * @ClassName: IOrderServices
 * @Description:
 * @Author: admin
 * @Create: 2022-04-24 16:19
 */
public interface IOrderServices {
    /**
     * @Description: 添加订单
     * @Author: admin
     * @Create: 2022/04/24-16:19
     * @param order
     * @Return void
     */
    void addOrder(Order order);

    /**
     * @Description: 通过邮箱帐号，获取订单
     * @Author: admin
     * @Create: 2022/04/24-16:56
     * @param
     * @Return java.util.List<com.li.domain.Order>
     */
    List<Order> queryOrderByEmail(String email,int status);

    /**
     * @Description: 订单已完成，将民宿屋重新上架 status:1 ;
     * 更新订单状态，status:-1
     * @Author: admin
     * @Create: 2022/04/24-18:56
     * @param order
     * @Return void
     */
    void successOrder(Order order);

    /**
     * @Description: 分页返回order
     * @Author: admin
     * @Create: 2022/04/24-22:09
     * @param pageStart
     * @param pageSize
     * @param map
     * @Return com.li.domain.PageBean<com.li.domain.Order>
     */
    PageBean<Order> pageOrder(String pageStart, String pageSize, Map<String, String[]> map);

}
