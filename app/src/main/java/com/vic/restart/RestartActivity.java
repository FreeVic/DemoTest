package com.vic.restart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.vic.R;
import com.vic.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Vic on 2016/6/27 0027.
 */
public class RestartActivity extends BaseActivity {


    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restart);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.button)
    public void click(){
        go2Activity(SecondActivity.class);
    }

}
