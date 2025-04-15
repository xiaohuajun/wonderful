package com.xiaohuajun.wonderful.async;

import lombok.Data;

import java.util.List;

/**
 * @author huawei
 */
@Data
public class ChangeCategory {


    private Long id;

    private String name;

    private Integer level;

    private List<ChangeCategory> children;

}

