package com.vic.lib.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vic on 2017/7/20 0020.
 */

public class APITest extends BaseTest {
    @Override
    protected void doSubTest() {
        testInteger();
    }

    public void testInteger(){
        // 存储在栈中的数据会进行复用
        List<Integer> list = new ArrayList<>();
        list.add(1000);
        list.add(1000);
        System.out.println(list.get(0) == list.get(1));

        String a = "ab";// 栈中声明变量a，然后去栈中找存放字面值"ab"的地址，如果有则返回这个地址，如果没有，则开辟一个存放字面值"ab"的地址，并赋给a
        String b = "a"+"b";
        String c = "abab";
        String d = "ab"+"ab";
        System.out.println(a == b);
        System.out.println((a+b) == c);
        System.out.println(c == d);

    }
}
