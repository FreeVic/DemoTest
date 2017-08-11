package com.vic.restart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.shizhefei.view.largeimage.LargeImageView;
import com.shizhefei.view.largeimage.factory.InputStreamBitmapDecoderFactory;
import com.vic.R;
import com.vic.applib.activity.BaseActivity;

import java.io.IOException;

import hugo.weaving.DebugLog;

/**
 * Created by Vic on 2016/6/27 0027.
 */
public class FourActivity extends BaseActivity {

    private View name;
    private View company;
    private View img;
    private View ll;
    private LinearLayout lll;

    @DebugLog
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_lin);
        name = findViewById(R.id.name);
        company = findViewById(R.id.company);
        img = findViewById(R.id.img);
        ll = findViewById(R.id.ll);
        lll = (LinearLayout) findViewById(R.id.lll);
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
//        LargeImageView largeImageView = (LargeImageView) findViewById(R.id.imageView);
        LargeImageView largeImageView = new LargeImageView(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) largeImageView.getLayoutParams();
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        lll.addView(largeImageView);

//通过文件的方式加载sd卡中的大图
//        largeImageView.setImage(new FileBitmapDecoderFactory(file));

//通过流的方式加载assets文件夹里面的大图
        try {
            largeImageView.setImage(new InputStreamBitmapDecoderFactory(getAssets().open("world.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
