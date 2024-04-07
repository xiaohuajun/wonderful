package com.xiaohuajun.wonderful.reactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

/**
 * @author xiaohuajun
 */
@Slf4j
@Component
public class Tesla {


    public static void main(String[] args) {
        Flux.generate(sink -> {
            sink.next("xiaohuajun");
            sink.complete();
        }).subscribe(System.out::println);
    }
}
