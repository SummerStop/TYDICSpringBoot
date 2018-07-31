package com.tydic.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReloadController {
    @RequestMapping(value = "/member_add", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public ModelAndView gotoMember_add(@RequestParam("rname") String rname) {
        ModelAndView mv = new ModelAndView("member-add");
        mv.addObject("rname",rname);
        return mv;
    }

}
