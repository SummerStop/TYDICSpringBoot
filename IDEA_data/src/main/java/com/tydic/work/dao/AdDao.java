package com.tydic.work.dao;

import com.tydic.work.bean.Repository;
import com.tydic.work.bean.Sku;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdDao {
    //添加货物信息相关逻辑
    //添加货物详情
    @Insert("insert into sku(cid,color,samount) values(#{cid} , #{color} , #{samount})")
    public void insert_sku(@Param("cid") int cid, @Param("color") String color, @Param("samount") int samount);
    //添加货物信息
    @Insert("insert into cargo(cname) values(#{cname} )")
    public void insert_cargo(@Param("cname") String cname);
    //添加货物与仓库关系
    @Insert("insert into relation(rid,cid,ramount) values(#{rid} , #{cid} , #{ramount})")
    public void insert_relation(@Param("rid") int rid, @Param("cid") int cid, @Param("ramount") int ramount);
    //修改货物总数量
    @Update("update relation set ramount = ramount + #{samount} where cid = #{cid}")
    public void update_relation(@Param("cid") int cid, @Param("samount") int samount);
    //获取货物id
    @Select("select cid from cargo where cname = #{cname}" )
    public Integer selectbycname(@Param("cname") String cname);
    //获取仓库id
    @Select("select rid from repo where rname = #{rname}" )
    public Integer selectbyrname(@Param("rname") String rname);


    //删除货物信息相关逻辑
    //获取该型号总数
    @Select("select samount from sku where sid = #{sid}" )
    public Integer selectbysid(@Param("sid") int sid);
    //获取该型号id
    @Select("select cid from sku where sid = #{sid}" )
    public Integer selectcidbysid(@Param("sid") int sid);
    //获取该型号总数
    @Select("select ramount from relation where cid = #{cid}" )
    public Integer selectramountbysid(@Param("cid") int cid);
    //修改总数
    @Update("update relation set ramount = ramount - #{samount} where cid = #{cid}")
    public void update_ramount(@Param("cid") int cid, @Param("samount") int samount);
    //删除相关内容
    @Delete("delete from sku where sid = #{sid}")
    public void delete_sku(@Param("sid") int sid);
    @Delete("delete from relation where cid = #{cid}")
    public void delete_relation(@Param("cid") int cid);
    @Delete("delete from cargo where cid = #{cid}")
    public void delete_cargo(@Param("cid") int cid);
}
