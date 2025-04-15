package com.xiaohuajun.wonderful.async;

import lombok.Data;


/**
 * @author huawei
 */
@Data
public class Dept {


    private Integer id;

    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Dept(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
