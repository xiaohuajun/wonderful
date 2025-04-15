package com.xiaohuajun.wonderful.design_model;

/**
 * @author huawei
 */
public class PolyTest {


    public static void main(String[] args) {
        Polymorphism cat = new Cat();
        cat.addAge(1);
        Polymorphism dog = new Dog();
        dog.addAge(2);
    }

}
