package com.tydic.work.service;

import com.tydic.work.bean.Sku;
import com.tydic.work.dao.AdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdService {
    @Autowired
    AdDao adDao;
    //添加逻辑
    public void insert_sku( int cid , String color , int samount ){
        adDao.insert_sku(cid, color, samount);
    }
    public void insert_cargo( String cname ){
        adDao.insert_cargo( cname);
    }
    public void insert_relation( int rid ,  int cid , int ramount ){
        adDao.insert_relation(rid, cid, ramount);
    }
    public void update_relation( int cid , int samount ){
        adDao.update_relation(cid, samount);
    }
    public Integer selectbycname( String cname ){
        return adDao.selectbycname(cname);
    }
    public Integer selectbyrname( String rname ){
        return adDao.selectbyrname(rname);
    }


    //删除逻辑
    public Integer selectbysid(int sid ){
        return adDao.selectbysid(sid);
    }
    public Integer selectcidbysid(int sid ){
        return adDao.selectcidbysid(sid);
    }
    public Integer selectramountbysid( int cid ){
        return adDao.selectramountbysid(cid);
    }
    public void update_ramount(int cid , int samount ){
        adDao.update_ramount(cid,samount);
    }
    public void delete_sku( int sid ){
        adDao.delete_sku(sid);
    }
    public void delete_relation(int cid ){
        adDao.delete_relation(cid);
    }
    public void delete_cargo(int cid ){
        adDao.delete_cargo(cid);
    }
}
