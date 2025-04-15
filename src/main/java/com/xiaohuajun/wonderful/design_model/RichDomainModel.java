package com.xiaohuajun.wonderful.design_model;

/**
 * @author huawei
 * 充血模型：不仅包含的属性数据，还包含对属性的业务方法、业务方法。。。。。。（数据+算法）更符合面向对象编程的思想--封装
 * 高度内聚；
 * 也可以使用在整个功能模块的设计上
 * 缺点：
 * 1、对象的代码量增加，当逻辑复杂的时候，业务方法比较复杂
 * 2、系统复杂度增加
 */
public class RichDomainModel {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 处理年龄-业务方法
     *
     * @param age 年龄
     */
    public void addAge(Integer age) {
        this.age += age + 1;
    }
}
