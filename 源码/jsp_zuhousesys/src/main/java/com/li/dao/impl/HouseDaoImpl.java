package com.li.dao.impl;

import com.li.dao.IHouseDao;
import com.li.domain.House;
import com.li.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Program: zuhousesys
 * @ClassName: HouseDaoImpl
 * @Description:
 * @Author: admin
 * @Create: 2022-04-24 13:13
 */
public class HouseDaoImpl implements IHouseDao {
    JdbcTemplate jt = new JdbcTemplate(JdbcUtils.getDs());

    //返回所有的民宿屋信息
    @Override
    public List<House> queryAllHouse() {
        String sql = "select * from  house where status = 1 order by cname";
        return jt.query(sql, new BeanPropertyRowMapper<House>(House.class));
    }

    //按租金倒序
    @Override
    public List<House> queryAllHouseByRentDesc() {
        String sql = "select * from  house where status = 1 order by crent desc";
        return jt.query(sql, new BeanPropertyRowMapper<House>(House.class));
    }

    //按租金升序
    @Override
    public List<House> queryAllHouseByRentAsc() {
        String sql = "select * from house where status = 1  order by crent";
        return jt.query(sql, new BeanPropertyRowMapper<House>(House.class));
    }

    //根据民宿屋位置模糊查询
    @Override
    public List<House> fuzzyQueryByHouse(String name) {
        String sql = "select * from house where status = 1 and cname like ?";
        String str = "%" + name + "%";
        return jt.query(sql, new BeanPropertyRowMapper<House>(House.class), str);

    }

    //根据民宿屋id 返回 house
    @Override
    public House queryHouseById(int id) {
        String sql = "select * from house where cid = ?";
        return jt.query(sql, new BeanPropertyRowMapper<House>(House.class), id).get(0);
    }

    //更改民宿屋状态
    @Override
    public void changeHouseStatus(int id, int status) {
        String sql = "update house set status = ? where cid = ?";
        jt.update(sql, status, id);
    }

    //分页加模糊查询,返回house
    @Override
    public List<House> pageHouse(int pageStart, int pageSize, Map<String, String[]> map) {
        StringBuilder sql = new StringBuilder();
        List<Object> list = new ArrayList<>();
        sql.append("select * from house where status != 0");

        Set<String> sets = map.keySet();

        for (String set : sets) {
            if ("".equals(map.get(set)[0]) || "".equals(map.get(set)[0])) {
                continue;
            } else if ("currentPage".equals(set) || "pageSize".equals(set)) {
                continue;
            } else if ("status".equals(set)) {
                sql.append(" and " + set + " like ?");
                list.add(map.get(set)[0]);
            } else {
                sql.append(" and " + set + " like ?");
                list.add("%" + map.get(set)[0] + "%");
            }
        }

        sql.append(" limit ?,?");
        list.add(pageStart);
        list.add(pageSize);

        return jt.query(sql.toString(), new BeanPropertyRowMapper<House>(House.class), list.toArray());
    }

    //返回模糊查询的数据总数
    @Override
    public int totalData(Map<String, String[]> map) {
        StringBuilder sql = new StringBuilder();
        List<Object> list = new ArrayList<>();
        sql.append("select count(1) from house where status != 0");

        Set<String> sets = map.keySet();

        for (String set : sets) {
            if ("".equals(map.get(set)[0]) || "".equals(map.get(set)[0])) {
                continue;
            } else if ("currentPage".equals(set) || "pageSize".equals(set)) {
                continue;
            } else if ("status".equals(set)) {
                sql.append(" and " + set + " like ?");
                list.add(map.get(set)[0]);
            } else {
                sql.append(" and " + set + " like ?");
                list.add("%" + map.get(set)[0] + "%");
            }
        }

        return jt.queryForObject(sql.toString(), Integer.class, list.toArray());
    }

    //下架
    @Override
    public void changHouseDown(int cid) {
        String sql = "update house set status = -1 where cid = ?";
        jt.update(sql, cid);
    }

    //添加民宿屋
    @Override
    public void addHouse(House house) {
        String sql = "insert into house values(null,?,?,?,?,?)";
        jt.update(sql, house.getCimg(), house.getCinfo(), house.getCname(), house.getCrent(), house.getStatus());
    }

    @Override
    public int totalHouse() {
        String sql = "select count(1) from house";
        return jt.queryForObject(sql, Integer.class);
    }


}
