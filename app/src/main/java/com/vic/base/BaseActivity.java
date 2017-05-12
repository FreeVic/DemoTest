package com.vic.base;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Vic on 2016/6/27 0027.
 */
public class BaseActivity extends FragmentActivity {
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
}
