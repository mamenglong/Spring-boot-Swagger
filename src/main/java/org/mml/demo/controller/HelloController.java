/*
  Created by IntelliJ IDEA.
  User: Long
  Date: 2018/10/18
  Time: 20:21
  To change this template use File | Settings | File Templates.
*/
package org.mml.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/hello")
public class HelloController {
    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
