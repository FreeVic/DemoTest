package com.vic.restart;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;

import com.vic.R;
import com.vic.applib.activity.BaseActivity;

import hugo.weaving.DebugLog;

/**
 * Created by Vic on 2016/6/27 0027.
 */
public class FourActivity extends BaseActivity {

    private View name;
    private View company;
    private View img;
    private View ll;
@DebugLog
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_lin);
        name = findViewById(R.id.name);
        company = findViewById(R.id.company);
        img = findViewById(R.id.img);
        ll = findViewById(R.id.ll);
    test();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(name!=null){
            System.out.println("name width="+name.getWidth()+" height="+name.getHeight());
        }
        if(company!=null){
            System.out.println("company width="+company.getWidth()+" height="+company.getHeight());
        }
        if(img!=null){
            System.out.println("img width="+img.getWidth()+" height="+img.getHeight());
        }
        if(img!=null){
            System.out.println("ll width="+ll.getWidth()+" height="+ll.getHeight());
        }
    }
    @DebugLog
    private void test(){
        SystemClock.sleep(1000);
    }
}
