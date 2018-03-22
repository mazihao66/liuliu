package com.mazihao.liuliu.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mazihao.liuliu.MainActivity;
import com.mazihao.liuliu.R;
import com.vondear.rxtools.RxActivityTool;
import com.vondear.rxtools.RxLogTool;
import com.vondear.rxtools.view.RxToast;

/**
 * Created by mazihao on 2018/2/7.
 */

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void testClick(View view) {

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                RxActivityTool.skipActivityAndFinish(WelcomeActivity.this, MainActivity.class);
            }
        }, 3000);

    }
}
