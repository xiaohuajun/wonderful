package com.xiaohuajun.wonderful.design_model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiaohuajun
 */
public class PolyTest {


    public static void main(String[] args) {
       String s = "0.15Ω";
        boolean needHandleNumValue = isNeedHandleNumValue(s);
        System.out.println("needHandleNumValue = " + needHandleNumValue);
        if (needHandleNumValue) {
            double number = handleNumberValue(s);
            System.out.println("number = " + number);
        }
        printCodePoints(s);
    }

    public static void printCodePoints(String str) {
        for (int i = 0; i < str.length(); i++) {
            int codePoint = str.codePointAt(i);
            System.out.println("位置 " + i + ": 字符 '" + str.charAt(i) + "' 的码点: " + codePoint
                    + " (0x" + Integer.toHexString(codePoint).toUpperCase() + ")");
        }
    }

    private static double handleNumberValue(String fieldValue) {
        String regex = "-?\\+?\\d+\\.?\\d*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fieldValue);
        BigDecimal number = new BigDecimal("0");
        while (matcher.find()) {
            number = new BigDecimal(matcher.group());
        }
        return number.setScale(4, RoundingMode.HALF_UP).doubleValue();
    }

    private static boolean isNeedHandleNumValue(String fieldValue) {
        String regexWithUnit = "(\\d+(\\.\\d+)?)\\s*([µμ]F|[µμ]H|Ω|mΩ|KΩ|MΩ|GΩ|TΩ|µΩ|[µμ]A|[µμ]V|[µμ]m|[µμ]s|[µμ]g|m/s|km/h|m/s2|kW·h)";
        Pattern patternUnit = Pattern.compile(regexWithUnit);
        Matcher matcherUnit = patternUnit.matcher(fieldValue);
        if (!matcherUnit.matches()) {
            String regex;
            if (isNumeric(fieldValue)) {
                regex = "-?\\+?\\d+\\.?\\d*";
            } else {
                regex = "-?\\+?\\d+\\.?\\d*\\w+";
            }
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(fieldValue);
            return matcher.matches();
        } else {
            return matcherUnit.matches();
        }
    }


    public static boolean isNumeric(String str) {
        if (Objects.isNull(str)) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}
