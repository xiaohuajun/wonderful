package com.xiaohuajun.wonderful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @author xiaohuajun
 * 不启用安全配置
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class WonderfulApplication {

  public static void main(String[] args) {
    SpringApplication.run(WonderfulApplication.class, args);
  }

}
