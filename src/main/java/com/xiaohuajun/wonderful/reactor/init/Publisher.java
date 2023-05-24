package com.xiaohuajun.wonderful.reactor.init;

import org.reactivestreams.Subscriber;

/**
 * @author xiaohuajun
 * 发布者
 */
public interface Publisher<T> {

    void subscribe(Subscriber<? super T> subscriber);

}
