package com.vic.restart;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.lzyzsd.randomcolor.RandomColor;
import com.pinyinsearch.model.PinyinSearchUnit;
import com.pinyinsearch.util.PinyinUtil;
import com.pinyinsearch.util.QwertyUtil;
import com.vic.R;
import com.vic.base.BaseActivity;
import com.vic.model.Person;
import com.vic.test.ActivityTest;
import com.vic.utils.UIUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Vic on 2016/6/27 0027.
 */
public class RestartActivity extends BaseActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tvTest)
    TextView tvTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restart);
        ButterKnife.bind(this);
        int statusBarHeight = UIUtil.getStatusBarHeight();
        System.out.println("status height:"+statusBarHeight);

        new ActivityTest().doTest();

    }

    public void delayTest(){
        int sum = 0;
        for(int i=0;i<100000;i++){
            sum+=i;
            System.out.println(sum);
        }
    }

    public void t5() {
        HashSet<Person> set = new HashSet<>();
        Person p1 = new Person("Jack");
        Person p2 = new Person("Dack");
        Person p3 = new Person("Tick");

        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set.size());

        p1.setAge(2);
        set.remove(p1);
        System.out.println(set.size());

        set.add(p1);
        System.out.println(set.size());
    }

    /**
     * 内部类持有外部类引用
     */
    public void t4() {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable1");
            }
        };

        Runnable2 runnable2 = new Runnable2();
        runnable1.run();
        runnable2.run();
    }


    @OnClick(R.id.button)
    public void click() {
//        go2Activity(SecondActivity.class);
        GradientDrawable shapeDrawable = (GradientDrawable) tvTest.getBackground();
        RandomColor randomColor = new RandomColor();
        shapeDrawable.setColor(randomColor.randomColor());
    }

    @OnClick(R.id.btn)
    public void btn() {
        String str = et.getText().toString();
        if (!TextUtils.isEmpty(str))
            UIUtil.showToast(str);
    }

    // 匹配拼音

    public void t3() {
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

    static class Runnable2 implements Runnable {

        public int arg1 = 1;

        @Override
        public void run() {
            System.out.println("runnable2");
        }
    }

}
