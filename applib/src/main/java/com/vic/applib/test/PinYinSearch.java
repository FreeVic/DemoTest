package com.vic.applib.test;

import com.pinyinsearch.model.PinyinSearchUnit;
import com.pinyinsearch.util.PinyinUtil;
import com.pinyinsearch.util.QwertyUtil;
import com.vic.lib.test.BaseTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vic on 2017/5/11 0011.
 */

public class PinYinSearch extends BaseTest {
    @Override
    protected void doSubTest() {
        testPinYin();
    }
    public void testPinYin() {
        List<MyUnit> list = new ArrayList<>();
        MyUnit unit = new MyUnit("蓝天");
        list.add(unit);
        list.add(new MyUnit("张根硕"));
        list.add(new MyUnit("赵日天"));
        list.add(new MyUnit("叶良辰"));
        list.add(new MyUnit("罗盖"));
        list.add(new MyUnit("廖东川"));

        for (MyUnit ps : list) {
            if (QwertyUtil.match(ps.getUnit(), "廖")) {
                System.out.println(ps.getUnit().getBaseData() + "-->" + ps.getUnit().getMatchKeyword());
            }
        }
    }
    class MyUnit {
        public PinyinSearchUnit unit;

        MyUnit(String baseData) {
            this.unit = new PinyinSearchUnit(baseData);
            PinyinUtil.parse(unit);
        }

        public PinyinSearchUnit getUnit() {
            return unit;
        }

        public void setUnit(PinyinSearchUnit unit) {
            this.unit = unit;
        }
    }
}
