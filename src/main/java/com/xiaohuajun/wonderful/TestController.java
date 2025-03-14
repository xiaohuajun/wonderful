package com.xiaohuajun.wonderful;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.MathContext;

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

    public static void main(String[] args) {
        long a = 1000 * 1000 * 1000;
        double pa = Math.pow(1000, 3);
        System.out.println("==========" + a);
        BigDecimal base = new BigDecimal(1000);
        BigDecimal result = BigDecimal.ONE.divide(base.pow(1), MathContext.DECIMAL128);
        System.out.println("+==============>"+ result);
    }

}
