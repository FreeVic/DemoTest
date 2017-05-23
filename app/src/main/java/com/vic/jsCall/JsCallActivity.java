package com.vic.jsCall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.vic.R;
import com.vic.applib.activity.BaseActivity;
import com.vic.restart.ThirdActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Vic on 2016/6/28 0028.
 */
public class JsCallActivity extends BaseActivity {
    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.btn)
    Button btn;
    private Test test;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js);
        ButterKnife.bind(this);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        test = new Test();
        webView.addJavascriptInterface(test, "test");
        webView.setWebChromeClient(new WebChromeClient()); //弹窗生效
        webView.loadUrl("file:///android_asset/test.html");

    }

    @OnClick(R.id.btn)
    void click() {
        System.out.println("call JS");
        webView.loadUrl("javascript:javacall()");
    }


    public class Test {
        @JavascriptInterface
        public void jump() {
            System.out.println("jump");
            go2Activity(ThirdActivity.class);
        }
    }
}
