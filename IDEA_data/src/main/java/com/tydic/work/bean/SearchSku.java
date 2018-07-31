package com.tydic.work.bean;

public class SearchSku {
    private int cid;    //货物id
    private String rname;    //仓库名称
    private String rplace;    //仓库地址
    private String cname;    // 货物名字
    private int ramount;    //货物总量

    public SearchSku(int cid, String rname, String rplace, String cname, int ramount) {
        this.cid = cid;
        this.rname = rname;
        this.rplace = rplace;
        this.cname = cname;
        this.ramount = ramount;
    }

    @Override
    public String toString() {
        return "SearchSku{" +
                "cid=" + cid +
                ", rname='" + rname + '\'' +
                ", rplace='" + rplace + '\'' +
                ", cname='" + cname + '\'' +
                ", ramount=" + ramount +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRplace() {
        return rplace;
    }

    public void setRplace(String rplace) {
        this.rplace = rplace;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getRamount() {
        return ramount;
    }

    public void setRamount(int ramount) {
        this.ramount = ramount;
    }
}
