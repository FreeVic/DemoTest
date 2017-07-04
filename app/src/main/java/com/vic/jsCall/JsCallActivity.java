package com.vic.jsCall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.vic.R;
import com.vic.applib.activity.BaseActivity;
import com.vic.restart.ThirdActivity;

/**
 * Created by Vic on 2016/6/28 0028.
 */
public class JsCallActivity extends BaseActivity {
    WebView webView;
    Button btn;
    private Test test;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js);
        webView = (WebView) findViewById(R.id.webView);
        btn = (Button) findViewById(R.id.btn);
        WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        test = new Test();
        this.webView.addJavascriptInterface(test, "test");
        this.webView.setWebChromeClient(new WebChromeClient()); //弹窗生效
        this.webView.loadUrl("file:///android_asset/test.html");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn:
                System.out.println("call JS");
                webView.loadUrl("javascript:javacall()");
                break;
        }
    }


    public class Test {
        @JavascriptInterface
        public void jump() {
            System.out.println("jump");
            go2Activity(ThirdActivity.class);
        }
    }
}
