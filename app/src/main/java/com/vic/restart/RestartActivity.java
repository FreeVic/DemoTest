package com.vic.restart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.vic.R;
import com.vic.base.BaseActivity;
import com.vic.utils.UIUtil;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restart);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void click() {
        go2Activity(SecondActivity.class);
    }

    @OnClick(R.id.btn)
    public void btn() {
        String str = et.getText().toString();
        if (TextUtils.isEmpty(str))
            UIUtil.showToast(str);
    }

}
