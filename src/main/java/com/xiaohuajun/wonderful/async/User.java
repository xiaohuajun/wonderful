package com.xiaohuajun.wonderful.async;

import lombok.Data;

/**
 * @author huawei
 */
@Data
public class User {

    private Integer id;

    private String name;

    private Integer age;

    private Integer deptId;

    private String deptName;

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
