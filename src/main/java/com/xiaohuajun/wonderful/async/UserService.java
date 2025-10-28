package com.xiaohuajun.wonderful.async;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.parsson.JsonUtil;

import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author huawei
 */
public class UserService {


    public void save(User user) {
        System.out.println("保存用户：" + user.toString() + "成功");
    }


    public static void main(String[] args) {
        String s = "{\"产品型号\":\"98424-F52-10ALF\",\"厂商\":\"Amphenol安费诺\",\"产品手册名称\":\"98424-F52-10ALF.pdf\",\"原厂链接\":\"\",\"标准符号名\":\"<span style='color:red'>10V</span>XG18000MEFC22X45\",\"标准封装名\":\"98424-F52-10ALF\",\"标准3DModel名\":\"98424-F52-10ALF\",\"描述\":\"\",\"库存\":\"\",\"价格\":\"\",\"包装\":\"卷带（TR）\",\"系列\":\"-\",\"产品状态\":\"\",\"连接器类型\":\"接头\",\"触头类型\":\"公形引脚\",\"间距 - 配接\":\"0.079\\\"（2.00mm）\",\"针位数\":\"10\",\"排数\":\"2\",\"排距 - 配接\":\"0.079\\\"（2.00mm）\",\"加载的针位数\":\"所有\",\"样式\":\"板至板或电缆\",\"护罩\":\"带遮蔽 - 4 墙\",\"安装类型\":\"表面贴装型\",\"端接\":\"焊接\",\"紧固类型\":\"锁存器支座\",\"接触长度 - 配接\":\"0.157\\\"（4.00mm）\",\"接触长度 - 柱\":\"-\",\"总体接触长度\":\"-\",\"绝缘高度\":\"0.244\\\"（6.20mm）\",\"触头形状\":\"方形\",\"触头表面处理 - 配接\":\"镀金\",\"触头表面处理厚度 - 配接\":\"闪存\",\"触头表面处理 - 柱\":\"锡\",\"触头材料\":\"铜合金\",\"绝缘材料\":\"热塑塑胶\",\"特性\":\"键槽，拾放\",\"工作温度\":\"-\",\"侵入防护\":\"-\",\"材料可燃性等级\":\"UL94 V-0\",\"绝缘颜色\":\"奶油色\",\"额定电流（安培）\":\"2A（AC/DC）\",\"额定电压\":\"200V（AC/DC）\"}";
       /* String regex = "\"厂商\":\"([^\"]+)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            // 提取捕获组中的值
            String manufacturer = matcher.group(1);
            System.out.println("厂商: " + manufacturer);
        } else {
            System.out.println("未找到匹配的厂商信息");
        }*/
        List<String> objects = new ArrayList<>();
        objects.add("描述");
        objects.add("厂商");
        objects.add("产品型号");
        objects.add("平台目录");
        objects.add("标准符号名");
        String s1 = removeNotNeedField(s, objects);
        //boolean jsonValid = isJsonValid(s);
        //System.out.println("++==" + jsonValid);
        System.out.println(s1);
    }

    private static String removeNotNeedField(String input, List<String> keyToRemove) {
        if (isJsonValid(input)) {
            JSONObject jsonObject = JSON.parseObject(input);
            for (String key : keyToRemove) {
                jsonObject.remove(key);
            }
            return jsonObject.toJSONString();
        } else {
            for (String k : keyToRemove) {
                String regex = "\"" + k + "\"\\s*:\\s*\"(?:[^\"\\\\]|\\\\.)*\"\\s*,?";
                input = input.replaceAll(regex, "");
            }
            input = input.replaceAll("\\s*,\\s*}", "}");
            return input;
        }
    }





    public static boolean isJsonValid(String jsonString) {
        try {
            // 尝试解析 JSON 字符串
            JSON.parseObject(jsonString);
            return true;
        } catch (Exception e) {
            // 如果解析失败，说明不是合法的 JSON
            return false;
        }
    }
}
