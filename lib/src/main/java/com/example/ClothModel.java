package com.example;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/15.
 */

public class ClothModel {
    @SerializedName("commoditie_quality")
    private ArrayList<Quality> quality;
    @SerializedName("commoditie_color")
    private Color color;
    @SerializedName("attributeMap")
    private Attribute attribute;
    public class Quality{
        @SerializedName("attribute_value")
        private String attValue;
        private int id;
        private String definition;
        private int productId;
        private int pro_id;
        private int pid;
        private String property;
        private int pav_id;

        public String getAttValue() {
            return attValue;
        }

        public void setAttValue(String attValue) {
            this.attValue = attValue;
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

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
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

    public class Color{


    }

    public class Attribute{
        private String product_id;
        private String product_attrvalue;
        private String underColor;
        private ArrayList<String> attributeValue;
        private ArrayList<String> attributeKey;

        @Override
        public String toString() {
            return "Attribute{" +
                    "product_id='" + product_id + '\'' +
                    ", product_attrvalue='" + product_attrvalue + '\'' +
                    ", underColor='" + underColor + '\'' +
                    ", attributeValue=" + attributeValue +
                    ", attributeKey=" + attributeKey +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ClothModel{" +
                "quality=" + quality +
                ", color=" + color +
                ", attribute=" + attribute +
                '}';
    }
}
