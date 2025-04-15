package com.xiaohuajun.wonderful.design_model;

/**
 * @author huawei
 * 贫血模型：只包含属性(存储数据)和getter、setter方法，不包含业务方法（算法）特别：是业务方法，都放在在业务层处理
 * 违背了面向对象的编程思想--封装
 * 优点：
 * 1、对象的代码量减少，当逻辑复杂的时候，业务方法比较简单
 * 2、系统复杂度降低
 * 缺点：
 * 1、高度耦合；
 * 2、代码的可重用性降低
 */
public class AnemicDomainModel {


    private String model;

    private String type;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
