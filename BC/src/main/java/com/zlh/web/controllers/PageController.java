package com.zlh.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: ZhouLinHu
 * @Description: 网页跳转控制器
 * @Date: Created in 13:17 2019/4/13
 */
@Controller
@RequestMapping("/")
public class PageController {

    @RequestMapping("newAccount.page")
    public String newAccount(){
        return "newAccount.html";
    }

    @RequestMapping("Mine.page")
    public String mine(){
        return "Mine.html";
    }

    @RequestMapping("BlockChain.page")
    public String BlockChain(){
        return "BlockChain.html";
    }

    @RequestMapping("Distributed.page")
    public String Distributed(){
        return "Distributed.html";
    }

    @RequestMapping("Transaction.page")
    public String Transaction(){
        return "Transaction.html";
    }
}

