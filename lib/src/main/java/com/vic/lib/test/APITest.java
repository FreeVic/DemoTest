package com.vic.lib.test;

import com.vic.lib.model.Person;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Vic on 2017/7/20 0020.
 */

public class APITest extends BaseTest {
    @Override
    protected void doSubTest() {
        testMap();
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

    void testList(){
        ArrayList<Person> list = new ArrayList<>();

        list.add(new Person("1",1));
        list.add(new Person("2",2));
        ArrayList<Person> result = new ArrayList<>(list);

        list.add(new Person("3",3));

        System.out.println("list ="+list.size());;
        System.out.println("result ="+result.size());

        list.get(0).setAge(10);
        System.out.println("list person:"+list.get(0));
        System.out.println("result person:"+result.get(0));

    }

    void testMap(){
        LinkedHashMap<String,Person> list = new LinkedHashMap<>();

        list.put("1",new Person("1",1));
        list.put("2",new Person("2",2));
        LinkedHashMap<String,Person> result = new LinkedHashMap<>(list);

        list.put("3",new Person("3",3));

        System.out.println("list ="+list.size());;
        System.out.println("result ="+result.size());

        list.get("1").setAge(10);
        System.out.println("list person:"+list.get("1"));
        System.out.println("result person:"+list.get("1"));
    }
}
