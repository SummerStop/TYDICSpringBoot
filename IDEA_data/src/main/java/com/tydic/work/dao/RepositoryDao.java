package com.tydic.work.dao;

import com.tydic.work.bean.Repository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RepositoryDao {
    @Select("select * from repo")
    public List<Repository> getUserList();
}
