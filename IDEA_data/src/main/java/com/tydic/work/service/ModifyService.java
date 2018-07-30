package com.tydic.work.service;

import com.tydic.work.dao.ModifyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ModifyService {
    @Autowired
    private ModifyDao modifyDao;

    public void updateCargoInfo(int sid, String cname, String color, int amount){
        modifyDao.updateCargoName(sid, cname);
        modifyDao.updateCargoSku(sid ,color, amount);
    }
}
