package com.tydic.work.dao;

import com.tydic.work.bean.Cargo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ModifyDao {
    @Update("update cargo set cname = #{arg1} where cid = " +
            "( select cid from sku where sid = #{arg0})")
    public void updateCargoName(int sid,String name);

    @Update("update sku set color = #{arg1}, samount = #{arg2} where sid = #{arg0}")
    public void updateCargoSku(int sid, String color, int amount);
}
