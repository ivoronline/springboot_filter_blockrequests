package com.ivoronline.springboot_filter_blockrequests.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @ResponseBody
  @RequestMapping("/Hello")
  public String hello(@RequestParam String username) {
    System.out.println("Hello from Controller");
    return "Hello " + username;
  }

}

