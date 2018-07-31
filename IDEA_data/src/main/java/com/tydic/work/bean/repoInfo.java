package com.tydic.work.bean;

public class repoInfo {
    private String rname;
    private String rplace;
    private String cname;
    private int ramount;
    private int cid;

    public repoInfo(String rname, String rplace, String cname, int ramount, int cid) {
        this.rname = rname;
        this.rplace = rplace;
        this.cname = cname;
        this.ramount = ramount;
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "repoInfo{" +
                "rname='" + rname + '\'' +
                ", rplace='" + rplace + '\'' +
                ", cname='" + cname + '\'' +
                ", ramount=" + ramount +
                ", cid=" + cid +
                '}';
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

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
