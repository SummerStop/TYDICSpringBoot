package com.tydic.work.bean;

public class Sku {
    private int sid;      //sku id
    private int cid;         //货物id
    private String color;      //单品颜色
    private int samount;      //单品数量

    public Sku(int sid, int cid, String color, int samount) {
        this.sid = sid;
        this.cid = cid;
        this.color = color;
        this.samount = samount;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "sid=" + sid +
                ", cid=" + cid +
                ", color='" + color + '\'' +
                ", samount=" + samount +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSamount() {
        return samount;
    }

    public void setSamount(int samount) {
        this.samount = samount;
    }
}
