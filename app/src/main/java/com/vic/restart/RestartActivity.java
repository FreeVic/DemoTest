package com.vic.restart;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.lzyzsd.randomcolor.RandomColor;
import com.vic.R;
import com.vic.applib.GlobalApplication;
import com.vic.applib.activity.BaseActivity;
import com.vic.applib.test.ActivityTest;
import com.vic.applib.utils.UIUtil;

/**
 * Created by Vic on 2016/6/27 0027.
 */
public class RestartActivity extends BaseActivity {


    private Button button;
    private TextView tvTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restart);
        button = (Button) findViewById(R.id.button);
        tvTest = (TextView) findViewById(R.id.tvTest);
        button.setOnClickListener(this);
        int statusBarHeight = UIUtil.getStatusBarHeight();
        System.out.println("status height:" + statusBarHeight);
        new ActivityTest().doTest();
        interceptHyperLink(tvTest);
        String string = getString(R.string.str_format, "112", null);
        System.out.println(string);

    }

    /**
     * 拦截超链接跳转
     *
     * @param tv
     */
    private void interceptHyperLink(TextView tv) {
        tv.setMovementMethod(LinkMovementMethod.getInstance());
        CharSequence text = tv.getText();
        if (text instanceof Spannable) {
            int end = text.length();
            Spannable spannable = (Spannable) tv.getText();
            URLSpan[] urlSpans = spannable.getSpans(0, end, URLSpan.class);
            if (urlSpans.length == 0) {
                return;
            }

            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            // 循环遍历并拦截 所有 http:// 开头的链接
            for (URLSpan uri : urlSpans) {
                String url = uri.getURL();
                if (url.indexOf("http") == 0) {
                    CustomUrlSpan customUrlSpan = new CustomUrlSpan(this, url);
                    spannableStringBuilder.setSpan(customUrlSpan, spannable.getSpanStart(uri),
                            spannable.getSpanEnd(uri), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                }
            }
            tv.setText(spannableStringBuilder);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                GradientDrawable shapeDrawable = (GradientDrawable) tvTest.getBackground();
                RandomColor randomColor = new RandomColor();
                shapeDrawable.setColor(randomColor.randomColor());
                break;
        }
    }

    class CustomUrlSpan extends ClickableSpan {

        private Context context;
        private String url;

        public CustomUrlSpan(Context context, String url) {
            this.context = context;
            this.url = url;
        }

        @Override
        public void onClick(View widget) {
            // 在这里可以做任何自己想要的处理
            Intent intent = new Intent();
            intent.setClass(GlobalApplication.getApplication(), ThirdActivity.class);
            context.startActivity(intent);
        }
    }
}
