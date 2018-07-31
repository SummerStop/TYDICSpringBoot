package com.tydic.work.controller;

import com.tydic.work.dao.RepositoryDao;
import com.tydic.work.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdController {
    @Autowired
    private AdService adService;

    @RequestMapping(value = "/insert", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    //添加
    public String insert(@RequestParam("cname") String cname , @RequestParam("color") String color , @RequestParam("samount") Integer samount , @RequestParam("rname") String rname ) {
        System.out.println(cname);
        System.out.println("asdasdasdasdasdas");
        //查重
        Integer cid ;
        cid = adService.selectbycname(cname);
        //该货物信息已经存在
        if(cid != null){
            //修改货物总量
            adService.update_relation(cid,samount);
            adService.insert_sku(cid,color,samount);
        }else{
            adService.insert_cargo(cname);
            cid = adService.selectbycname(cname);
            adService.insert_sku(cid,color,samount);
            Integer rid = adService.selectbyrname(rname);
            adService.insert_relation(rid,cid,samount);
        }
        return "/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String delete(@RequestParam("sid") Integer sid ) {
        Integer samount = adService.selectbysid(sid);
        Integer cid = adService.selectcidbysid(sid);
        Integer ramount = adService.selectramountbysid(sid);
        if(samount == null){
            return "没有该信息";
        }
        if(samount.equals(ramount)){
            adService.delete_sku(sid);
            adService.delete_relation(cid);
            adService.delete_cargo(cid);
        }else{
            adService.update_ramount(cid,samount);
            adService.delete_sku(sid);
        }
        return "删除成功";
    }

    @RequestMapping(value = "/repo3", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String insert(@RequestParam("cname") String cname ) {
        return cname;
    }
}
