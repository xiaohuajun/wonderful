package com.xiaohuajun.wonderful.async;

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
        String s = "\"输出配置\":\"正\",\"电压-供电(Vcc/Vdd)\":\"8V~35V\",\"宽度\":\"3.90mm\",\"最大工作温度\":\"85°C（TA）\",\"占空比（最大）\":\"49%\",\"高度_double\":1.75,\"频率-开关\":\"100Hz~400kHz\",\"标准3DModel名\":\"SOIC16-1r27-9r9x3r9-H1r75\",\"描述\":\"W&X&Y&Z&AA\",\"厂商\":\"ST意法半导体\",\"产品型号\":\"SG2525AP013TR\",\"最小工作温度\":\"-25°C\",\"拓扑\":\"降压，推挽\",\"脚距\":\"1.27mm\",\"时钟同步\":\"是\",\"长度\":\"9.90mm\",\"宽度_double\":3.9,\"输出相位\":\"1\",\"管脚数量\":\"16\",\"高度\":\"1.75mm\",\"包装方式\":\"编带（TapeandReel）\",\"最小工作温度_double\":-25.0,\"环保符合\":\"RoHS\",\"产品手册名称\":\"SG2525AP013TR.pdf\",\"输出数_double\":2.0,\"脚距_double\":1.27,\"输出数\":\"2\",\"标准符号名\":\"SG2525AP013TR\",\"标准封装名\":\"SOIC16-1r27-9r9x3r9-H1r75\",\"输出类型\":\"晶体管驱动器\",\"控制特性\":\"使能，软启动\",\"功能\":\"降压，升压/降压\",\"输出相位_double\":1.0,\"管脚数量_double\":16.0,\"封装类型\":\"SOIC-16\",\"安装方式\":\"表面安装SMT\",\"同步整流器\":\"是\",\"长度_double\":9.9,\"最大工作温度_double\":85.0";
        String regex = "\"厂商\":\"([^\"]+)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            // 提取捕获组中的值
            String manufacturer = matcher.group(1);
            System.out.println("厂商: " + manufacturer);
        } else {
            System.out.println("未找到匹配的厂商信息");
        }
    }
}
