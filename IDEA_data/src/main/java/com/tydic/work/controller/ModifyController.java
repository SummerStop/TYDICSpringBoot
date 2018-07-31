package com.tydic.work.controller;

import com.tydic.work.service.ModifyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModifyController {

    @Autowired
    private ModifyService modifyService;

    @RequestMapping(value = "/modifyCargoInfo",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public ModelAndView modifyCargoInfo(@RequestParam("sid") Integer sid,
                                        @RequestParam("color") String color, @RequestParam("samount") Integer samount){
        Integer newAmount = modifyService.selectRamountBySid(sid) - modifyService.selectSamountBySid(sid) + samount;
        modifyService.updateRamountBySid(sid, newAmount);
        modifyService.updateCargoInfo(sid, color, samount);

        ModelAndView mv = new ModelAndView("repo");
        return mv;
    }
}
