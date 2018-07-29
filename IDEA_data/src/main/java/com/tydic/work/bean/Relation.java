package com.tydic.work.bean;

public class Relation {
    private int id;     //关系id
    private int rid;      //仓库id
    private int cid;        //货物id
    private int ramount;     //货物数量

    public Relation(int id, int rid, int cid, int ramount) {
        this.id = id;
        this.rid = rid;
        this.cid = cid;
        this.ramount = ramount;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "id=" + id +
                ", rid=" + rid +
                ", cid=" + cid +
                ", ramount=" + ramount +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getRamount() {
        return ramount;
    }

    public void setRamount(int ramount) {
        this.ramount = ramount;
    }
}
