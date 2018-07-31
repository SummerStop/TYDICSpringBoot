package com.tydic.work.dao;

import com.tydic.work.bean.Cargo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ModifyDao {
    //修改sku信息
    @Update("update sku set color = #{arg1}, samount = #{arg2} where sid = #{arg0}")
    public void updateCargoSku(Integer sid, String color, Integer samount);

    //根据sid修改数量ramount
    @Update("update relation set ramount = #{arg1} where cid = (select cid from sku where sid = #{arg0})")
    public void updateRamountBySid(Integer sid, Integer ramount);

    //根据sid获取数量ramount
    @Select("select ramount from relation where cid = (select cid from sku where sid = #{arg0})")
    public Integer selectRamountByCid(Integer sid);

    //根据sid获取数量samount
    @Select("select samount from sku where sid = #{arg0}")
    public Integer selectSamountByCid(Integer sid);
}
