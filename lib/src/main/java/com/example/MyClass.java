package com.example;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

public class MyClass {
    public static void main(String[] args){
        MyClass myClass = new MyClass();
        myClass.t1();
    }

    void t1(){
        String str = "{\"commoditie_quality\":[{\"attribute_value\":\"金属\",\"id\":31,\"definition\":\"commoditie_quality\"," +
                "\"product_id\":12,\"pro_id\":31,\"pid\":12,\"property\":\"材质\",\"pav_id\":358}]," +
                "\"commoditie_color\":{\"358\":[{\"attribute_value\":\"银色\",\"id\":32,\"price\":\"26\"," +
                "\"definition\":\"commoditie_color\",\"product_id\":12,\"coin\":\"1\",\"img\":[{\"face\":\"face\"," +
                "\"img\":\"12f0a3f9e0.png\",\"rect\":null}],\"pro_id\":32,\"pid\":0,\"property\":\"颜色\",\"pav_id\":267}]}," +
                "\"attributeMap\":{\"product_id\":\"314\",\"attributeValue\":[\"材质\",\"颜色\"],\"product_attrvalue\":\"233\"," +
                "\"attributeKey\":[\"commoditie_quality\",\"commoditie_color\"],\"underColor\":\"2\"}}";
        Gson gson = new Gson();
        ClothModel model = null;
        model = gson.fromJson(str.toString(), ClothModel.class);

        System.out.println(model.toString());


    }
}
