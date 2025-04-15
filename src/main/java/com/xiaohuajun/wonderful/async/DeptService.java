package com.xiaohuajun.wonderful.async;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author huawei
 */
public class DeptService {


    public Dept getById(int id) {
        return new Dept(id, "研发部");
    }


    public static void main(String[] args) {
        ChangeCategory changeCategory = getChangeCategory();
        List<CategoryRespDTO> categoryList = getCategoryList();
        List<CategoryRespDTO> categoryRespTree = buildCategoryTree(categoryList);
        Long l = compareCategory(changeCategory, categoryRespTree);
        System.out.println("============>" + l);
    }

    private static void getFinalCategoryName(ChangeCategory changeCategory, StringBuilder fullName) {
        List<ChangeCategory> children = changeCategory.getChildren();
        if (CollectionUtils.isEmpty(children)) {
            fullName.append(changeCategory.getName());
        } else {
            fullName.append(changeCategory.getName()).append("/");
            getFinalCategoryName(children.get(0), fullName);
        }
    }


    private static Long getFinalCategoryId(ChangeCategory changeCategory) {
        List<ChangeCategory> children = changeCategory.getChildren();
        if (CollectionUtils.isEmpty(children)) {
            return changeCategory.getId();
        } else {
            return getFinalCategoryId(children.get(0));
        }
    }


    private static Long compareCategory(ChangeCategory changeCategory, List<CategoryRespDTO> categoryList) {
        String name = changeCategory.getName();
        Map<String, List<CategoryRespDTO>> nameMap = categoryList.stream().collect(Collectors.groupingBy
                (CategoryRespDTO::getName));
        List<CategoryRespDTO> categoryRespListByName = nameMap.get(name);
        if (CollectionUtils.isEmpty(categoryRespListByName)) {
            return null;
        } else {
            CategoryRespDTO categoryRespDTO = categoryRespListByName.get(0);
            //单选children只有一个
            List<ChangeCategory> children = changeCategory.getChildren();
            List<CategoryRespDTO> childrenTargetList = categoryRespDTO.getChildren();
            if (CollectionUtils.isEmpty(children) && CollectionUtils.isEmpty(childrenTargetList)) {
                return categoryRespDTO.getId();
            } else if (CollectionUtils.isEmpty(children)) {
                return null;
            } else {
                return compareCategory(children.get(0), childrenTargetList);
            }
        }
    }

    private static List<CategoryRespDTO> getCategoryList() {
        return Arrays.asList(
                new CategoryRespDTO(89621842729370624L, "陶瓷电容器", 2, 1, 89621842712593408L, null, 2, 87327933370207744L, 0, 0, 158, 158),
                new CategoryRespDTO(154125265868688384L, "zz", 2, 1, 154125265818356736L, null, 2, 87327933370207744L, null, 0, 0, 0),
                new CategoryRespDTO(88185185169838080L, "电阻器", 1, 1, 0L, null, 2, 87327933370207744L, 0, 2, 4, 4),
                new CategoryRespDTO(88185185203392512L, "片式电阻器 - 表面贴装", 2, 1, 88185185169838080L, null, 2, 87327933370207744L, 0, 0, 3, 3),
                new CategoryRespDTO(118571552622077952L, "变压器配件", 2, 1, 118571552563357696L, null, 2, 87327933370207744L, null, 0, 0, 0),
                new CategoryRespDTO(286715955886137344L, "测试变更2", 2, 1, 286715884918513664L, null, 2, 87327933370207744L, null, 1, 11, 11),
                new CategoryRespDTO(286716040820793344L, "测试变更34", 3, 1, 286715955886137344L, null, 2, 87327933370207744L, null, 0, 11, 11),
                new CategoryRespDTO(89621842712593408L, "电容器", 1, 2, 0L, null, 2, 87327933370207744L, 0, 1, 158, 158),
                new CategoryRespDTO(89612511116002304L, "电阻器网络，阵列", 2, 2, 88185185169838080L, null, 2, 87327933370207744L, 0, 0, 1, 1),
                new CategoryRespDTO(118571552563357696L, "变压器", 1, 3, 0L, null, 2, 87327933370207744L, null, 1, 0, 0),
                new CategoryRespDTO(154125265818356736L, "zzz", 1, 4, 0L, null, 2, 87327933370207744L, null, 1, 0, 0),
                new CategoryRespDTO(286715884918513664L, "测试变更1", 1, 5, 0L, null, 2, 87327933370207744L, null, 1, 11, 11)
        );
    }


    private static List<CategoryRespDTO> buildCategoryTree(List<CategoryRespDTO> currentOrgCategories) {
        Map<Long, CategoryRespDTO> map = new HashMap<>();
        List<CategoryRespDTO> roots = new ArrayList<>();
        // 将所有节点放入映射中
        for (CategoryRespDTO category : currentOrgCategories) {
            map.put(category.getId(), category);
        }
        // 构建树结构
        for (CategoryRespDTO category : currentOrgCategories) {
            if (category.getParentId() == 0) {
                roots.add(category);
            } else {
                CategoryRespDTO parent = map.get(category.getParentId());
                if (parent != null) {
                    parent.getChildren().add(category);
                }
            }
        }
        return roots;
    }

    public static ChangeCategory getChangeCategory() {
        ChangeCategory changeCategory = new ChangeCategory();
        changeCategory.setId(164433872048754700L);
        changeCategory.setName("测试变更1");
        changeCategory.setLevel(1);
        //2级
        List<ChangeCategory> children = new ArrayList<>();
        ChangeCategory changeCategory2 = new ChangeCategory();
        changeCategory2.setId(164433872048754711L);
        changeCategory2.setName("测试变更2");
        changeCategory2.setLevel(2);
        children.add(changeCategory2);
        changeCategory.setChildren(children);
        //3级
        List<ChangeCategory> children2 = new ArrayList<>();
        ChangeCategory changeCategory3 = new ChangeCategory();
        changeCategory3.setId(164433872048754718L);
        changeCategory3.setName("测试变更3");
        changeCategory3.setLevel(3);
        children2.add(changeCategory3);
        changeCategory2.setChildren(children2);
        return changeCategory;
    }

}
