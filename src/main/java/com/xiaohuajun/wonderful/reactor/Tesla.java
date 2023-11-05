package com.xiaohuajun.wonderful.reactor;

import reactor.core.publisher.Flux;

public class Tesla {


    public static void main(String[] args) {
        Flux.generate(sink -> {
            sink.next("xiaohuajun");
            sink.complete();
        }).subscribe(System.out::println);
    }
}
