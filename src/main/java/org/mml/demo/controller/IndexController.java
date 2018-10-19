/*
  Created by IntelliJ IDEA.
  User: Long
  Date: 2018/10/19
  Time: 16:56
  To change this template use File | Settings | File Templates.
*/
package org.mml.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
    @GetMapping
    public String index(){
        return "index";
    }
}
