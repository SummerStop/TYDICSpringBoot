package com.tydic.work.controller;

import com.tydic.work.bean.Relation;
import com.tydic.work.bean.Repository;
import com.tydic.work.bean.SearchSku;
import com.tydic.work.bean.Sku;
import com.tydic.work.dao.RepositoryDao;
import com.tydic.work.dao.SelectDao;
import com.tydic.work.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class SelectController {
    // @Autowired
    //private SelectDao selectDao;

    @Autowired
    private SelectService selectService;
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getHello() {
        return "Hello,Word!!!xxxxxxxxxxxx";
    }

    @RequestMapping(value = "/repo", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<Repository> getRepo() {
        return selectService.getListRepo();
    }

    @RequestMapping(value = "/getCargo", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<Relation> getCargo() {
        //测试仓库1
        return selectService.getCargoByRid(1);
    }

    @RequestMapping(value = "/getSku", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<Sku> getSku() {
        //测试货物1
        return selectService.getSkuByCid(1);
    }

    @RequestMapping(value = "/Search", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<SearchSku> getSearch(){
        //测试模糊搜索查询
        return selectService.SearchByCargoName("%1%");
    }
}
