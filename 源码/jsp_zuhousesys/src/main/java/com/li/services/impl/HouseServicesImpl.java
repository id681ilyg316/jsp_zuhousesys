package com.li.services.impl;

import com.li.dao.IHouseDao;
import com.li.dao.impl.HouseDaoImpl;
import com.li.domain.House;
import com.li.domain.PageBean;
import com.li.services.IHouseServices;

import java.util.List;
import java.util.Map;

/**
 * @Program: zuhousesys
 * @ClassName: HouseServicesImpl
 * @Description:
 * @Author: admin
 * @Create: 2022-04-24 13:52
 */
public class HouseServicesImpl implements IHouseServices {
    IHouseDao dao = new HouseDaoImpl();

    //将民宿屋进行排序
    //1:按租金升序，0:按民宿屋位置排序,-1:按租金降序
    @Override
    public List<House> sortHouses(int status) {
        if(status == 1){
            return dao.queryAllHouseByRentAsc();
        }else if (status == 0){
            return dao.queryAllHouse();
        }else {
            return dao.queryAllHouseByRentDesc();
        }
    }

    @Override
    public List<House> fuzzyQueryByHouse(String name) {
        return dao.fuzzyQueryByHouse(name);
    }

    @Override
    public House queryHouseById(int id) {
        return dao.queryHouseById(id);
    }

    @Override
    public PageBean<House> pageHouse(String _pageStart, String _pageSize, Map<String, String[]> map) {
        int pageStart = Integer.parseInt(_pageStart);
        int pageSize = Integer.parseInt(_pageSize);

        List<House> houses = dao.pageHouse((pageStart - 1) * pageSize, pageSize, map);
        int totalData = dao.totalData(map);
        return new PageBean<House>(pageStart, pageSize, totalData, houses);
    }

    @Override
    public void changHouseDown(int cid) {
        dao.changHouseDown(cid);
    }

    @Override
    public void addHouse(House house) {
        dao.addHouse(house);
    }

    @Override
    public void changeHouseStatus(int id, int status) {
        dao.changeHouseStatus(id,status);
    }


}
