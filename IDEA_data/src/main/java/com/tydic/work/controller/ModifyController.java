package com.tydic.work.controller;

import com.tydic.work.service.ModifyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ModifyController {

    @Autowired
    private ModifyService modifyService;

    @RequestMapping(value = "/modifyCargoInfo",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifyCargoInfo(@Param("sid") int sid, @Param("cname") String cname,
                                  @Param("color") String color, @Param("amount") int amount){
        modifyService.updateCargoInfo(sid, cname,color, amount);
        System.out.println("sid = [" + sid + "], cname = [" + cname + "], color = [" + color + "], amount = [" + amount + "]");
        return "ok";
    }
}
