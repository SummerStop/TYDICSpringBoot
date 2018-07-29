package com.tydic.work.controller;

import com.tydic.work.bean.Repository;
import com.tydic.work.dao.RepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class userController {
    @Autowired
    private RepositoryDao repo;

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getHello() {
        return "Hello,Word!!!xxxxxxxxxxxx";
    }

    @RequestMapping(value = "/repo", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<Repository> getUser() {
        return repo.getUserList();
    }
}
