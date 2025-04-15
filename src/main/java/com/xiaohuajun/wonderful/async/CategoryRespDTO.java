package com.xiaohuajun.wonderful.async;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huawei
 */

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getLevelSort() {
        return levelSort;
    }

    public void setLevelSort(Integer levelSort) {
        this.levelSort = levelSort;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Integer getChildNum() {
        return childNum;
    }

    public void setChildNum(Integer childNum) {
        this.childNum = childNum;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public Integer getPublicProductNum() {
        return publicProductNum;
    }

    public void setPublicProductNum(Integer publicProductNum) {
        this.publicProductNum = publicProductNum;
    }

    public List<CategoryRespDTO> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryRespDTO> children) {
        this.children = children;
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
