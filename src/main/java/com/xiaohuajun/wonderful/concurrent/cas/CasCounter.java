package com.xiaohuajun.wonderful.concurrent.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/1/3 下午3:04
 * @description CasDetail 使用cas实现，线程计数器
 */
public class CasCounter {

  private AtomicInteger atomicInteger = new AtomicInteger(0);

  private int i = 0;

  private void safeCount() {
    //无限循环
    for (; ;) {
      //旧值
      int i = atomicInteger.get();
      //新值 = ++i
      boolean suc = atomicInteger.compareAndSet(i, ++i);
      if (suc) {
        break;
      }
    }
  }

  public static void main(String[] args) {
    CasCounter casCounter = new CasCounter();
    List<Thread> tsList = new ArrayList<>(20);
    long start = System.currentTimeMillis();
    for (int i = 0; i < 5; i++) {
      Thread t = new Thread(() -> {
        for (int j = 0; j < 100; j++) {
          casCounter.safeCount();
        }
      });
      tsList.add(t);
    }

    for (Thread thread : tsList) {
      thread.start();
    }

    for (Thread thread : tsList) {
      try {
        //让主线程等待:与sleep区别：sleep必须指定时间，join可以不指定时间，在不确定需要让主线程等待多少时间时
        //使用join
       thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println(casCounter.i);
    System.out.println(casCounter.atomicInteger.get());
    System.out.println(System.currentTimeMillis() - start);

  }


}
