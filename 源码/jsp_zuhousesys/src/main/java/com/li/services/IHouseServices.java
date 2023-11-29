package com.li.services;

import com.li.domain.House;
import com.li.domain.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Program: zuhousesys
 * @ClassName: IHouseServices
 * @Description:
 * @Author: admin
 * @Create: 2022-04-24 13:49
 */
public interface IHouseServices {
    /**
     * @Description: 将民宿屋进行排序
     * @Author: admin
     * @Create: 2022/04/24-13:50
     * @param status 1:按租金升序，0:按民宿屋位置排序,-1:按租金降序
     * @Return java.util.List<com.li.domain.User>
     */
    List<House> sortHouses(int status);

    /**
     * @Description: 根据民宿屋位置模糊查询
     * @Author: admin
     * @Create: 2022/04/24-14:18
     * @param name
     * @Return java.util.List<com.li.domain.House>
     */
    List<House> fuzzyQueryByHouse(String name);

    /**
     * @Description: 根据民宿屋id 返回 house
     * @Author: admin
     * @Create: 2022/04/24-15:47
     * @param id
     * @Return com.li.domain.House
     */
    House queryHouseById(int id);

    /**
     * @Description: 分页返回house
     * @Author: admin
     * @Create: 2022/04/24-20:01
     * @param pageStart
     * @param pageSize
     * @param map
     * @Return com.li.domain.PageBean<com.li.domain.House>
     */
    PageBean<House> pageHouse(String pageStart, String pageSize, Map<String, String[]> map);

    /**
     * @Description: 下架
     * @Author: admin
     * @Create: 2022/04/24-20:57
     * @param cid
     * @Return void
     */
    void changHouseDown(int cid);

    /**
     * @Description: 添加民宿屋
     * @Author: admin
     * @Create: 2022/04/24-21:24
     * @param house
     * @Return void
     */
    void addHouse(House house);

    /**
     * @Description: 更改民宿屋状态
     * @Author: admin
     * @Create: 2022/04/24-16:22
     * @param id
     * @param status
     * @Return void
     */
    void changeHouseStatus(int id , int status);

}
