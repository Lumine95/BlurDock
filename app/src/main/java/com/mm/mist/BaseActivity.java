package com.mm.mist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ZMM on 2018/4/13 19:29.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        initView();
    }

    public abstract int getLayoutId();

    public abstract void initView();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
