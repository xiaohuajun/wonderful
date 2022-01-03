package com.xiaohuajun.wonderful.concurrent.cas;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/1/3 下午3:04
 * @description CasDetail cas 详解：利用cpu的cmpxchg指令实现， 包括三个运算：内存地址：V，期望值：（旧值）A
 * 被线程修改后的新值：B；工作流程：1.每次从内存获取旧值，2.线程对旧值进行修改，3.比较期望值与目前V内存地址中的值
 * 是否相等
 */
public class CasDetail {


}
