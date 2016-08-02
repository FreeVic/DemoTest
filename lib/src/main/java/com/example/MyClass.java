package com.example;

import com.google.gson.Gson;
import com.pinyinsearch.model.PinyinSearchUnit;
import com.pinyinsearch.util.QwertyUtil;

import java.io.File;
import java.lang.annotation.ElementType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class MyClass {
    /**
     * attributeKey : ["cloth_color","cloth_material","cloth_sleeve"]
     * underColor : 1
     */

    private AttributeMapBean attributeMap;
    private List<ProductBean> product;

    public static void main(String[] args){
        MyClass myClass = new MyClass();
//        myClass.t3();
        myClass.t4();
    }

    public void loopFile(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File tmpFile:files){
                if(file.isDirectory()){
                    loopFile(tmpFile);
                }else {
                    isPng(tmpFile);
                }
            }
        }else{
            isPng(file);
        }

    }

    public void isPng(File file){
        String path = file.getAbsolutePath();
//        if(path.endsWith("png")){
            String fileType = GetTypeByHead.getFileType(path);
            if(null==fileType||!fileType.equalsIgnoreCase("png")){
                System.out.println(path);
            }
//        }
    }

    public void t4(){
        File file = new File("D:\\log.xml");
        file.renameTo(new File("D:\\log1111.xml"));
    }

    public void t3(){
        File file = new File("C:\\worksapce\\Eclite5006\\AndroidEcLite43\\app\\src\\main\\res");
        loopFile(file);
    }
    
    
    public String t2(){
        long stamp = 4102419661000l;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(stamp);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(calendar.getTime());
        System.out.println(str);
        return str;
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

    public AttributeMapBean getAttributeMap() {
        return attributeMap;
    }

    public void setAttributeMap(AttributeMapBean attributeMap) {
        this.attributeMap = attributeMap;
    }

    public List<ProductBean> getProduct() {
        return product;
    }

    public void setProduct(List<ProductBean> product) {
        this.product = product;
    }

    public static class AttributeMapBean {
        private String underColor;
        private List<String> attributeKey;

        public String getUnderColor() {
            return underColor;
        }

        public void setUnderColor(String underColor) {
            this.underColor = underColor;
        }

        public List<String> getAttributeKey() {
            return attributeKey;
        }

        public void setAttributeKey(List<String> attributeKey) {
            this.attributeKey = attributeKey;
        }
    }

    public static class ProductBean {
        /**
         * attribute_value : 白色
         * id : 4
         * definition : cloth_color
         * product_id : 1
         * color : #ffffff
         * pro_id : 4
         * pid : 0
         * property : 颜色
         * pav_id : 14
         */

        private List<ClothColorBean> cloth_color;

        public List<ClothColorBean> getCloth_color() {
            return cloth_color;
        }

        public void setCloth_color(List<ClothColorBean> cloth_color) {
            this.cloth_color = cloth_color;
        }

        public static class ClothColorBean {
            private String attribute_value;
            private int id;
            private String definition;
            private int product_id;
            private String color;
            private int pro_id;
            private int pid;
            private String property;
            private int pav_id;

            public String getAttribute_value() {
                return attribute_value;
            }

            public void setAttribute_value(String attribute_value) {
                this.attribute_value = attribute_value;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDefinition() {
                return definition;
            }

            public void setDefinition(String definition) {
                this.definition = definition;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public int getPro_id() {
                return pro_id;
            }

            public void setPro_id(int pro_id) {
                this.pro_id = pro_id;
            }

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public String getProperty() {
                return property;
            }

            public void setProperty(String property) {
                this.property = property;
            }

            public int getPav_id() {
                return pav_id;
            }

            public void setPav_id(int pav_id) {
                this.pav_id = pav_id;
            }
        }
    }
}
