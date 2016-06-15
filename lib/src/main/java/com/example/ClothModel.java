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
