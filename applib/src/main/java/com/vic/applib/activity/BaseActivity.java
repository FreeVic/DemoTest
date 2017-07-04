package com.vic.applib.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * Created by Vic on 2016/6/27 0027.
 */
public class BaseActivity extends FragmentActivity implements View.OnClickListener{
    /**
     * @param targetActivity
     */
    public void go2Activity(Class targetActivity) {
        Intent intent = new Intent(this, targetActivity);
        startActivity(intent);
//        overridePendingTransition(R.anim.push_bottom_in,R.anim.push_up_out);
    }

    @Override
    public void finish() {
        super.finish();
//        overridePendingTransition(R.anim.push_up_in, R.anim.push_bottom_out);
    }

    @Override
    public void onClick(View view) {

    }
}
