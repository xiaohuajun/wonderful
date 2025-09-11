package com.xiaohuajun.wonderful.design_model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Objects;

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

    public static void main(String[] args) {
        String searchParams = "{\"ingredientText\": \"PC/PET\", \"ingredientTable\": {\"headers\": [\"元素\", \"C\", \"Si\", \"Mn\", \"P\", \"S\", \"Ni\", \"Cr\", \"Mo\", \"Al\"], \"data\": [[\"Wt%\", \"≤0.09\", \"≤1\", \"≤1\", \"≤0.035\", \"≤0.03\", \"6.5~7.5\", \"14~16\", \"2~3\", \"0.75~1.5\"],[\"Ht%\", \"≤0.19\", \"≤12\", \"≤12\", \"≤0.135\", \"≤0.034\", \"2.5~7.5\", \"13~16\", \"12~13\", \"7.5~9.5\"],[\"Kt%\", \"≤0.129\", \"≤112\", \"≤212\", \"≤0.1325\", \"≤0.01334\", \"23.5~47.5\", \"13~96\", \"112~132\", \"17.5~19.5\"]]}}";
        String newSearchParams = handleIngredient(searchParams);
        System.out.println(newSearchParams);
    }

}
