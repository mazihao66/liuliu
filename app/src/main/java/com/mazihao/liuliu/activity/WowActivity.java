package com.mazihao.liuliu.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.mazihao.liuliu.MainActivity;
import com.mazihao.liuliu.R;
import com.mazihao.liuliu.myview.WowSplashView;
import com.mazihao.liuliu.myview.WowView;
import com.vondear.rxtools.RxActivityTool;
import com.vondear.rxtools.RxBarTool;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mazihao on 2018/2/7.
 * 酷炫闪屏页  https://github.com/githubwing/WingUE
 */

public class WowActivity extends AppCompatActivity {

    @BindView(R.id.wowSplash)
    WowSplashView mWowSplash;
    @BindView(R.id.wowView)
    WowView mWowView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置全屏
        RxBarTool.FLAG_FULLSCREEN(WowActivity.this);

        setContentView(R.layout.activity_wow);
        ButterKnife.bind(this);

        mWowSplash.startAnimate();

        mWowSplash.setOnEndListener(new WowSplashView.OnEndListener() {
            @Override
            public void onEnd(WowSplashView wowSplashView) {
                mWowSplash.setVisibility(View.GONE);
                mWowView.setVisibility(View.VISIBLE);
                mWowView.startAnimate(wowSplashView.getDrawingCache());

                //跳转到主页面
                RxActivityTool.skipActivityAndFinish(WowActivity.this, WelcomeActivity.class);
            }
        });
    }
}
