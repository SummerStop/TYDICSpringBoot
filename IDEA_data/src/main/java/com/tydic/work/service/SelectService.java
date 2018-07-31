package com.tydic.work.service;

import com.tydic.work.bean.*;
import com.tydic.work.dao.SelectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectService {
    @Autowired
    private SelectDao selectdao;

    public List<Repository> getListRepo(){
        return selectdao.getListRepo();
    }

    public List<Relation> getCargoByRid(int rid){
        return selectdao.getCargoByRid(rid);
    }

    public List<Sku> getSkuByCid(int cid){
        return selectdao.getSkuByCid(cid);
    }

    public List<SearchSku> SearchByCargoName(String cname){
        return selectdao.SearchByCargoName(cname);
    }

    public List<repoInfo> getRepoInfoByRid(Integer rid){
        return selectdao.getRepoInfoByRid(rid);
    }

    public Sku getSkuBySid(Integer sid){
        return selectdao.getSkuBySid(sid);
    }

    public Cargo getCargoByCid(Integer cid){
        return selectdao.getCargoByCid(cid);
    }

    public Repository getRepoByRid(Integer rid){
        return selectdao.getRepoByRid(rid);
    }

    public Repository getRepoNameByCid(Integer cid){
        return selectdao.getRepoByRid(selectdao.getRelationByCid(cid).getRid());
    }
}
