package com.tydic.work.controller;

import com.tydic.work.bean.*;
import com.tydic.work.dao.RepositoryDao;
import com.tydic.work.dao.SelectDao;
import com.tydic.work.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public ModelAndView getRepo() {
        ModelAndView mv = new ModelAndView("repo");
        List<Repository> list = selectService.getListRepo();
        mv.addObject("repoList",list);
        return mv;
    }        //仓库列表

    @RequestMapping(value = "/getCargo", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public ModelAndView getCargo(@RequestParam("rid") Integer rid) {
        //测试仓库1
        ModelAndView mv = new ModelAndView("cargo");
        List<repoInfo> list = selectService.getRepoInfoByRid(rid);
        mv.addObject("cargoList",list);
        Repository repo = selectService.getRepoByRid(rid);
        mv.addObject("repo",repo);
        return mv;
    }   //仓库里的货物

    @RequestMapping(value = "/getSku", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public ModelAndView getSku(@RequestParam("cid") Integer cid) {
        //测试货物1
        ModelAndView mv = new ModelAndView("sku");
        List<Sku> list = selectService.getSkuByCid(cid);
        mv.addObject("skuList",list);
        Repository repo = selectService.getRepoNameByCid(cid);
        mv.addObject("repoName",repo);
        return mv;
    }        //货物详情

    @RequestMapping(value = "/Search", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public ModelAndView getSearch(@RequestParam("username") String username){
        //测试模糊搜索查询
        ModelAndView mv = new ModelAndView("SearchSku");
        System.out.println(username);
        List<SearchSku> list = selectService.SearchByCargoName("%"+username+"%");
        mv.addObject("SearchList",list);
        return mv;
    }

    //得到修改的sku
    @RequestMapping(value = "/getSkuBySid", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public ModelAndView getSkuBySid(@RequestParam("sid") Integer sid,@RequestParam("cid") Integer cid){
        //测试模糊搜索查询
        ModelAndView mv = new ModelAndView("member-edit");
        Sku sku = selectService.getSkuBySid(sid);
        Cargo cargo = selectService.getCargoByCid(cid);
        mv.addObject("skuInfo",sku);
        mv.addObject("cargo",cargo);
        return mv;
    }
}
