package com.xiaohuajun.wonderful.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/12/18 上午7:57
 * @description DemoController
 */
@RestController
@RequestMapping("/person")
public class DemoController {

  @GetMapping("/getint")
  public String test(){
    return "hello world";
  }
}
