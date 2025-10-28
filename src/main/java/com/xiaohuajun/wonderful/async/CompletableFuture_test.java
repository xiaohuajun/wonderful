package com.xiaohuajun.wonderful.async;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import io.micrometer.core.instrument.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author huawei
 */
public class CompletableFuture_test {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*DeptService deptService = new DeptService();
        UserService userService = new UserService();
        User user = new User(1, "huajun", 31);
        CompletableFuture<Void> userCompletableFuture = CompletableFuture.supplyAsync(() -> {
            Dept dept = deptService.getById(1);
            return dept;
        }).thenAccept(dept -> {
            //注意这里用到了上个线程的返回值dept
            user.setDeptId(dept.getId());
            user.setDeptName(dept.getName());
            userService.save(user);
        });
        System.out.println("线程：" + Thread.currentThread().getName() +
                " 结果：" + userCompletableFuture.get());*/
        /*String s = "adb@535_720/POL+%12测试";
        boolean validGrade = isValidGrade(s);*/
        //System.out.println("validGrade = " + validGrade);
        //String  s = "[{\"securityLevel\":\"2\",\"<span style='color:red'>密度</span>\":\"<span style='color:red'>7.1</span>g/cm³\",\"<span style='color:red'>密度</span>测试标准\":\"GB/T 1432-1996\",\"propertyId\":\"387626642774949376\"},{\"securityLevel\":\"2\",\"杨氏模量\":\"172.0GPa\",\"杨氏模量测试标准\":\"GB/T 22315-2<span style='color:red'>00</span>8\",\"propertyId\":\"387626642808503808\"},{\"securityLevel\":\"3\",\"泊松比测试标准\":\"GB/T 22315-2<span style='color:red'>00</span>8\",\"泊松比\":\"0.275\",\"propertyId\":\"387626642842058240\"},{\"securityLevel\":\"2\",\"比热容\":\"460-602J/(kg·℃)\",\"比热容测试标准\":\"ASTM E1269-24\",\"propertyId\":\"387626642934332928\"},{\"securityLevel\":\"2\",\"热导率\":\"32.3W/(m·K)\",\"propertyId\":\"387626642967887360\",\"热导率测试标准\":\"GB/T 32064-2015\"},{\"securityLevel\":\"2\",\"热膨胀系数测试条件\":\"21℃-<span style='color:red'>900</span>℃\",\"热膨胀系数测试标准\":\"GB/T 4339-2<span style='color:red'>00</span>8\",\"propertyId\":\"387626643<span style='color:red'>00</span>98304<span style='color:red'>00</span>\",\"热膨胀系数\":\"13.7μstrain/℃\"}]";
        //转为List
        //JSONArray list = JSON.parseArray(s);
        //String s = "<span style='color:red'>1</span>";
        //String r = s.replaceAll("<span[^>]*>", "").replaceAll("</span>", "");
        String value = "2.1千米/时";
        String reg = "^([-+]?\\d*\\.?\\d+(?:/\\d+\\.?\\d+)?)([\\u4e00-\\u9fa5/]+)";
        if (value.matches(reg)) {
            System.out.println("单位转换成功====>" + value);
        } else {
            System.out.println("单位转换失败====>"+ value);
        }
        //正则 分离出 数值 ， 单位
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            String number = matcher.group(1);
            System.out.println("数值====>" + number);
            String unit = matcher.group(2);
            System.out.println("单位====>" + unit);
        }

        BigDecimal fahrenheit = new BigDecimal(67);
        BigDecimal celsius = fahrenheit.subtract(new BigDecimal("32")).multiply(new BigDecimal("5")).divide(new BigDecimal("9"), 4, RoundingMode.HALF_UP);
        String plainString = celsius.stripTrailingZeros().toPlainString();
        // boolean chinese = isChinese(u);
        System.out.println("list = " + plainString);
    }

    private static boolean isValidGrade(String partNumber) {
        String componentPattern = "^[\\w\\s®™©\\-./+@%]+$";
        if (StringUtils.isEmpty(partNumber) || partNumber.length() < 2) {
            return false;
        }
        return partNumber.matches(componentPattern);
    }


    public static boolean isChinese(String unitName) {
        String regex = "[\\u4e00-\\u9fa5]+";
        return Pattern.matches(regex, unitName);
    }


}
