package com.vic.restart;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.easing.Glider;
import com.daimajia.easing.Skill;
import com.eclite.map.SampleActivity;
import com.github.lzyzsd.randomcolor.RandomColor;
import com.vic.BuildConfig;
import com.vic.R;
import com.vic.applib.GlobalApplication;
import com.vic.applib.activity.BaseActivity;
import com.vic.applib.test.ActivityTest;
import com.vic.applib.utils.ToastUtil;
import com.vic.applib.utils.UIUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import timber.log.Timber;

/**
 * Created by Vic on 2016/6/27 0027.
 */
public class RestartActivity extends BaseActivity {


    private Button button;
    private TextView tvTest;
    private TextView code;
    private View parent;
    private View laySecond;
    private View layFirst;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restart);
        button = (Button) findViewById(R.id.button);
        tvTest = (TextView) findViewById(R.id.tvTest);
        code = findViewById(R.id.code);
        parent = findViewById(R.id.parent);
        layFirst = findViewById(R.id.layFirst);
        laySecond = findViewById(R.id.laySecond);
        button.setOnClickListener(this);
        code.setOnClickListener(this);
        int statusBarHeight = UIUtil.getStatusBarHeight();
        System.out.println("status height:" + statusBarHeight);
        interceptHyperLink(tvTest);
        System.out.println("buildConfigField="+BuildConfig.example);

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
    private int index = 0;
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                GradientDrawable shapeDrawable = (GradientDrawable) tvTest.getBackground();
                RandomColor randomColor = new RandomColor();
                shapeDrawable.setColor(randomColor.randomColor());
                Random random = new Random();
                ToastUtil.show(String.valueOf(random.nextInt(100)));
                break;
            case R.id.code:
               if(index%2 == 0){
                   fadeOut();
               }else{
                   fadeIn();
               }
               index++;
                break;
        }
    }

    private void fadeOut(){
        AnimatorSet set = new AnimatorSet();
        set.playSequentially(
                Glider.glide(Skill.Linear, 1200, ObjectAnimator.ofFloat(parent, "translationX", 0, -1000)),
                Glider.glide(Skill.Linear, 1200, ObjectAnimator.ofFloat(parent, "translationX", 1000,0)),
                Glider.glide(Skill.Linear, 1200, ObjectAnimator.ofFloat(parent, "scaleX", 1,0)),
                Glider.glide(Skill.Linear, 1200, ObjectAnimator.ofFloat(parent, "scaleY", 1,0))
        );

        set.addListener(new MyAnimatorListener(){
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                parent.setVisibility(View.GONE);
            }
        });
        set.start();

    }

    private void fadeIn(){
        parent.setVisibility(View.VISIBLE);
        AnimatorSet set = new AnimatorSet();
        set.playSequentially(
                Glider.glide(Skill.Linear, 2200, ObjectAnimator.ofFloat(parent, "scaleX", 0,1)),
                Glider.glide(Skill.Linear, 2200, ObjectAnimator.ofFloat(parent, "scaleY", 0,1))
        );

        set.addListener(new MyAnimatorListener(){
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });
        set.start();
    }

    private void fadeGone(){
        AnimatorSet setX = new AnimatorSet();
        setX.playTogether(

        );

        setX.setDuration(1200);
        setX.addListener(new MyAnimatorListener(){
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                parent.setVisibility(View.GONE);
            }
        });
        setX.start();
    }

    class MyAnimatorListener implements Animator.AnimatorListener{
        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {

        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

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
            intent.setClass(GlobalApplication.getApplication(), SampleActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        new ActivityTest().doTest();
        Timber.i("resume re");
        calendar();
    }

    private void calendar() {
        ContentValues values = new ContentValues();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginTime = null;
        try {
            beginTime = simpleDateFormat.parse("2017-09-11 10:10:10");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date endTime = null;
        try {
            endTime = simpleDateFormat.parse("2017-09-11 11:11:11");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        values.put(CalendarContract.Events.CALENDAR_ID, 1);
        values.put(CalendarContract.Events.TITLE, "Check stackoverflow.com");
        values.put(CalendarContract.Events.DTSTART, beginTime.getTime());
        values.put(CalendarContract.Events.DTEND, endTime.getTime());
        values.put(CalendarContract.Events.EVENT_TIMEZONE, TimeZone.getDefault().getID());

        values.put(CalendarContract.Events.CUSTOM_APP_PACKAGE, getPackageName());
        values.put(CalendarContract.Events.CUSTOM_APP_URI, "myAppointment://1");

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        getContentResolver().insert(CalendarContract.Events.CONTENT_URI, values);
    }
}
