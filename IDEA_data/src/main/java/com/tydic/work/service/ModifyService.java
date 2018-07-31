package com.tydic.work.service;

import com.tydic.work.dao.ModifyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ModifyService {
    @Autowired
    private ModifyDao modifyDao;

    //修改sku信息
    public void updateCargoInfo(Integer sid, String color, Integer amount){
        modifyDao.updateCargoSku(sid ,color, amount);
    }

    //根据sid修改数量ramount
    public void updateRamountBySid(Integer sid, Integer ramount){
        modifyDao.updateRamountBySid(sid,ramount);
    }

    //根据sid获取数量ramount
    public Integer selectRamountBySid(Integer sid){
        return modifyDao.selectRamountByCid(sid);
    }

    //根据sid获取数量samount
    public Integer selectSamountBySid(Integer sid){
        return modifyDao.selectSamountByCid(sid);
    }

}
