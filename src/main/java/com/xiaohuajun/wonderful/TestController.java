package com.xiaohuajun.wonderful;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huawei
 */
@RestController
@RequestMapping("/config")
@Slf4j
public class TestController {

    @GetMapping ("/hello")
    public String test(){
        log.info("config request enter.");
        return "hello world";
    }


}
