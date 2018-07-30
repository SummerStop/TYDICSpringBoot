package com.tydic.work.service;

import com.tydic.work.bean.Relation;
import com.tydic.work.bean.Repository;
import com.tydic.work.bean.SearchSku;
import com.tydic.work.bean.Sku;
import com.tydic.work.dao.SelectDao;
import org.apache.ibatis.annotations.Select;
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
}
