package com.vic.restart;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.vic.R;
import com.vic.base.BaseActivity;
import com.vic.jsCall.JsCallActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Vic on 2016/6/27 0027.
 */
public class SecondActivity extends BaseActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.js)
    Button js;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
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

    @OnClick(R.id.button)
    void click() {
        go2Activity(ThirdActivity.class);
    }

    @OnClick(R.id.js)
    void callJS() {
        go2Activity(JsCallActivity.class);
    }
}
