package com.vic.restart;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.vic.R;
import com.vic.applib.activity.BaseActivity;
import com.vic.jsCall.JsCallActivity;

/**
 * Created by Vic on 2016/6/27 0027.
 */
public class SecondActivity extends BaseActivity implements View.OnClickListener {

    /**
     * JS
     */
    private Button js;
    /**
     * Second Activity
     */
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();

        String url = "http://xiazai.xiazaiba.com/Soft/O/Opera_38.0.2220.29_XiaZaiBa.zip?pcid=82&filename=Opera_38.0.2220" +
                ".29_XiaZaiBa.zip&downloadtype=xiazaiba_original";
//        download(url);
    }

    void download(String url) {
        //创建下载任务,downloadUrl就是下载链接
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
//指定下载路径和下载文件名
        request.setDestinationInExternalPublicDir("/download/", System.currentTimeMillis() + "");
//获取下载管理器
        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
//将下载任务加入下载队列，否则不会进行下载
        downloadManager.enqueue(request);
    }

    private void initView() {
        js = (Button) findViewById(R.id.js);
        js.setOnClickListener(this);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.js:
                go2Activity(JsCallActivity.class);
                break;
            case R.id.button:
                go2Activity(ThirdActivity.class);
                break;
        }
    }
}
