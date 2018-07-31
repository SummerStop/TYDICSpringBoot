package com.tydic.work.dao;

import com.tydic.work.bean.*;
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

    @Select("select rp.rname,rp.rplace,cg.cname,rl.ramount,cg.cid from repo rp,relation rl,cargo cg where rp.rid=#{rid} and rp.rid=rl.rid and rl.cid=cg.cid")
    public List<repoInfo> getRepoInfoByRid(Integer rid);

    @Select("select * from sku where sid=#{sid}")
    public Sku getSkuBySid(Integer sid);

    @Select("select * from cargo where cid=#{cid}")
    public Cargo getCargoByCid(Integer cid);

    @Select("select * from repo where rid=#{rid}")
    public Repository getRepoByRid(Integer rid);

    @Select("select * from relation where cid=#{cid}")
    public Relation getRelationByCid(Integer cid);
}
