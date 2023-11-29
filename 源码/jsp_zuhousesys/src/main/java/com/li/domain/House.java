package com.li.domain;

/**
 * @Program: zuhousesys
 * @ClassName: House
 * @Description:
 * @Author: admin
 * @Create: 2022-04-24 13:07
 */
public class House {
    //民宿屋编号
    private int cid;
    //民宿屋图片
    private String cimg;
    //民宿屋信息
    private String cinfo;
    //民宿屋名称
    private String cname;
    //民宿屋租金
    private double crent;
    //民宿屋状态 -1 下架 ；0 出租 ；1 可租
    private int status;

    public House(int cid, String cimg, String cinfo, String cname, double crent, int status) {
        this.cid = cid;
        this.cimg = cimg;
        this.cinfo = cinfo;
        this.cname = cname;
        this.crent = crent;
        this.status = status;
    }

    public House(String cimg, String cinfo, String cname, double crent, int status) {
        this.cimg = cimg;
        this.cinfo = cinfo;
        this.cname = cname;
        this.crent = crent;
        this.status = status;
    }

    public House() {
    }

    @Override
    public String toString() {
        return "House{" +
                "cid=" + cid +
                ", cimg='" + cimg + '\'' +
                ", cinfo='" + cinfo + '\'' +
                ", cname='" + cname + '\'' +
                ", crent=" + crent +
                ", status=" + status +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCimg() {
        return cimg;
    }

    public void setCimg(String cimg) {
        this.cimg = cimg;
    }

    public String getCinfo() {
        return cinfo;
    }

    public void setCinfo(String cinfo) {
        this.cinfo = cinfo;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public double getCrent() {
        return crent;
    }

    public void setCrent(double crent) {
        this.crent = crent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
