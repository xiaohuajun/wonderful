package com.xiaohuajun.wonderful.design_model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.Charsets;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author huawei
 */
public class PolymorphismT {


    public void addAge(Integer age) {
        age += 1;
    }


    private static String handleIngredient(String ingredient) {
        if (StringUtils.isNotEmpty(ingredient)) {
            JSONObject ingredientNewObj = new JSONObject();
            JSONObject ingredientObj = JSONObject.parseObject(ingredient);
            ingredientNewObj.put("成分", ingredientObj.get("ingredientText"));
            JSONObject ingredientTable = (JSONObject) ingredientObj.get("ingredientTable");
            //处理成分表格
            if (Objects.nonNull(ingredientTable)) {
                JSONArray headers = ingredientTable.getJSONArray("headers");
                JSONArray data = ingredientTable.getJSONArray("data");
                if (!CollectionUtils.isEmpty(headers) && !CollectionUtils.isEmpty(data)) {
                    JSONObject result = new JSONObject();
                    for (int colIndex = 0; colIndex < headers.size(); colIndex++) {
                        String key = headers.getString(colIndex);
                        JSONArray values = new JSONArray();
                        for (int rowIndex = 0; rowIndex < data.size(); rowIndex++) {
                            JSONArray row = data.getJSONArray(rowIndex);
                            values.add(row.getString(colIndex));
                        }
                        result.put(key, values);
                    }
                    ingredientNewObj.put("成分表", result);
                }
            } else {
                ingredientNewObj.put("成分表", "");
            }
            return ingredientNewObj.toJSONString();
        }
        return null;
    }

    private static final Pattern POLYMER_PATTERN = Pattern.compile(
            "(" +
                    // ====== 1. 塑料基材（Resin）======
                    "pc|abs|pa|pp|pe|pbt|pet|pmma|pa6|pa66|peek|ps|pvc|" +
                    "hdpe|ldpe|mdpe|ppo|pom|tpu|tpe|san|ca|cp|pen|" +
                    // ====== 2. 改性/增强/性能标识（Modifier/Property）======
                    "gf|fg|cf|mf|cr|" +           // 增强：玻纤、碳纤、矿物、铬纤
                    "fr|" +                       // 阻燃
                    "v0|v1|v2|hb|5va|5vb|" +      // UL 阻燃等级
                    "ht|" +                       // 耐热（High Heat）
                    "uv|" +                       // 耐候/抗紫外线
                    "esd|static|antistatic|" +    // 抗静电
                    "food\\s*grade|fda|nsf|" +    // 食品级
                    "impact|hi|" +                // 高抗冲
                    "lcp|" +                      // 液晶聚合物（也属基材，但常出现在牌号中）
                    "transparent|clear|optical" + // 透明/光学级
                    ")",
            Pattern.CASE_INSENSITIVE
    );

    public static Set<String> transformKeyword(String input) {
        Matcher matcher = POLYMER_PATTERN.matcher(input);
        // 保持顺序，去重
        Set<String> keywords = new LinkedHashSet<>();
        while (matcher.find()) {
            keywords.add(matcher.group(1).toLowerCase());
        }
        return keywords;
    }


    public static void main(String[] args) {
        /*String text = "耐磨铜合金；主要用于继电器簧片、56Gbps高速连接器\u200C、轴承衬套、同步器齿环\u200C、船舶阀门、化工泵体。";
        System.out.println("原始长度: " + text.length());
        String cleaned = removeHiddenChars(text);*/
        //System.out.println("清理后: " + cleaned);
        String k = "1mr";
        //boolean match = isSpecialGrade(k);
        //Set<String> keywords = transformKeyword(k);
        //Date date = add(new Date(), 5,-1);
        //格式化日期
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String key = matchKey(k);
        System.out.println("匹配是否查询属性: " + key);
    }

    public static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(calendarField, amount);
            return c.getTime();
        }
    }

    private static String matchKey(String keyword) {
        Pattern pattern = Pattern.compile("^(\\d+(?:\\.\\d+)?)([kKmM][rR]?|[rR])$");
        Matcher matcher = pattern.matcher(keyword);
        if (matcher.find()) {
            String number = matcher.group(1);
            String unit = matcher.group(2);
            if ("k".equalsIgnoreCase(unit) || "kr".equalsIgnoreCase(unit)) {
                return number + "KΩ";
            }
            if ("m".equals(unit) || "mr".equals(unit) || "mR".equals(unit)) {
                return number + "mΩ";
            }
            if ("M".equals(unit) || "Mr".equals(unit) || "MR".equals(unit)) {
                return number + "MΩ";
            }
            if ("r".equalsIgnoreCase(unit)) {
                return number + "Ω";
            }
        }
        return keyword;
    }

    private static boolean match(String keyword) {
        return keyword.matches("^(?!\\d+$)(?:[\\u4e00-\\u9fa5a-zA-Z]+\\s*[:：=]?\\s*)?\\d+(?:\\.\\d+)?(?:[a-zA-Z\\u4e00-\\u9fa5%‰±⁰¹²³⁴⁵⁶⁷⁸⁹⁻⁺·/]+)?$");
    }

    private static boolean isSpecialGrade(String keyword) {
        // keyword 全是英文 || 全是数字 || 包含特殊字符
        return keyword.matches("^(?:[a-zA-Z]+|\\d+)$");
    }

    private static boolean matchPlus(String keyword) {
        return keyword.matches("^[a-zA-Z\\u4e00-\\u9fa5]+\\s*\\+\\s*[a-zA-Z\\u4e00-\\u9fa5]+$");
    }


    private static String removeHiddenChars(String input) {
        if (StringUtils.isEmpty(input)) {
            return input;
        }
        //去掉隐藏字符
        String hiddenCharRegex = "[\\u200B-\\u200F\\uFEFF\\u00A0\\r\\n\\t]";
        if (input.matches(".*" + hiddenCharRegex + ".*")) {
            return input.replaceAll(hiddenCharRegex, "");
        } else {
            return input;
        }
    }


}
