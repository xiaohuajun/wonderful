package com.xiaohuajun.wonderful.algo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        String m = "this    is   text but is not value";
        Pattern p = Pattern.compile("this\\s+is\\s+text");
        Matcher matcher = p.matcher(m);
        int i = matcher.groupCount();
        for (int j = 0; j < i; j++) {
            System.out.println(matcher.group(j));
        }
    }
}
