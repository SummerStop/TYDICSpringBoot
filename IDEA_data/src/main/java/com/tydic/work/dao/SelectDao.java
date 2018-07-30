package com.tydic.work.dao;

import com.tydic.work.bean.Relation;
import com.tydic.work.bean.Repository;
import com.tydic.work.bean.SearchSku;
import com.tydic.work.bean.Sku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface SelectDao {
    @Select("select * from repo")
    public List<Repository> getListRepo();

    @Select("select * from relation where rid = #{rid}")
    public List<Relation> getCargoByRid(int rid);

    @Select("select * from sku where cid = #{cid}")
    public List<Sku> getSkuByCid(int cid);

    @Select("select cg.cid,rp.rname,rp.rplace,cg.cname,rl.ramount from repo rp,cargo cg,relation rl where cg.cname like #{cname} and rl.cid = cg.cid and rp.rid = rl.rid")
    public List<SearchSku> SearchByCargoName(String cname);
}
