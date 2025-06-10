package com.xiaohuajun.wonderful.async;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huawei
 */

@Setter
@Getter
@Data
public class CategoryRespDTO {

    private Long id;
    private String name;
    private Integer level;
    private Integer levelSort;
    private Long parentId;
    private Long templateId;
    private Integer type;
    private Long orgId;
    private Integer image;
    private Integer childNum;
    private Integer productNum;
    private Integer publicProductNum;
    private List<CategoryRespDTO> children;

    // 构造函数、getter 和 setter 方法
    public CategoryRespDTO(Long id, String name, Integer level, Integer levelSort, Long parentId, Long templateId,
                           Integer type, Long orgId, Integer image, Integer childNum, Integer productNum, Integer publicProductNum) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.levelSort = levelSort;
        this.parentId = parentId;
        this.templateId = templateId;
        this.type = type;
        this.orgId = orgId;
        this.image = image;
        this.childNum = childNum;
        this.productNum = productNum;
        this.publicProductNum = publicProductNum;
        this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "CategoryRespDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", levelSort=" + levelSort +
                ", parentId=" + parentId +
                ", templateId=" + templateId +
                ", type=" + type +
                ", orgId=" + orgId +
                ", image=" + image +
                ", childNum=" + childNum +
                ", productNum=" + productNum +
                ", publicProductNum=" + publicProductNum +
                ", children=" + children +
                '}';
    }



}
