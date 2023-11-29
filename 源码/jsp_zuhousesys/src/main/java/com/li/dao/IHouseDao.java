package com.li.dao;

import com.li.domain.House;

import java.util.List;
import java.util.Map;

/**
 * @Program: zuhousesys
 * @ClassName: IHouseDao
 * @Description:
 * @Author: admin
 * @Create: 2022-04-24 13:11
 */
public interface IHouseDao {
    /**
     * @Description: 返回所有的民宿屋信息,按民宿屋位置排序
     * @Author: admin
     * @Create: 2022/04/24-13:36
     * @param
     * @Return java.util.List<com.li.domain.House>
     */
    List<House> queryAllHouse();

    /**
     * @Description: 按租金倒序
     * @Author: admin
     * @Create: 2022/04/24-13:36
     * @param
     * @Return java.util.List<com.li.domain.House>
     */
    List<House> queryAllHouseByRentDesc();

    /**
     * @Description: 按租金升序
     * @Author: admin
     * @Create: 2022/04/24-13:36
     * @param
     * @Return java.util.List<com.li.domain.House>
     */
    List<House> queryAllHouseByRentAsc();

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
     * @Description: 更改民宿屋状态
     * @Author: admin
     * @Create: 2022/04/24-16:22
     * @param id
     * @param status
     * @Return void
     */
    void changeHouseStatus(int id , int status);

    /**
     * @Description: 分页加模糊查询,返回house
     * @Author: admin
     * @Create: 2022/04/24-19:58
     * @param pageStart
     * @param pageSize
     * @param map
     * @Return java.util.List<com.li.domain.House>
     */
    List<House> pageHouse(int pageStart, int pageSize, Map<String, String[]> map);

    /**
     * @Description: 返回模糊查询的数据总数
     * @Author: admin
     * @Create: 2022/04/23-20:57
     * @param map
     * @Return int
     */
    int totalData(Map<String, String[]> map);

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
     * @Description: 返回车总数
     * @Author: admin
     * @Create: 2022/04/25-15:26
     * @param
     * @Return int
     */
    int totalHouse();


}
