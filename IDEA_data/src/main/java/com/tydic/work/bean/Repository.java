package com.tydic.work.bean;


public class Repository {
    private int rid;       //仓库id
    private String rname;   //仓库名字
    private String rplace;    //仓库地址

    public Repository(int rid, String rname, String rplace) {
        this.rid = rid;
        this.rname = rname;
        this.rplace = rplace;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", rplace='" + rplace + '\'' +
                '}';
    }

    public int getRid() {
        return rid;
    }

    public String getRname() {
        return rname;
    }

    public String getRplace() {
        return rplace;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public void setRplace(String rplace) {
        this.rplace = rplace;
    }
}
