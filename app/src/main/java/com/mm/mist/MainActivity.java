package com.mm.mist;

import android.Manifest;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.tbruyelle.rxpermissions2.RxPermissions;

import androidx.cardview.widget.CardView;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.iv_background) ImageView ivBackground;
    @BindView(R.id.cv_blur) CardView cvBlur;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    private void pickColor() {
        ColorPickerDialogBuilder
                .with(this)
                .setTitle("选择颜色")
                .initialColor(R.color.colorAccent)
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .density(12)
                .setOnColorSelectedListener(selectedColor -> cvBlur.setCardBackgroundColor(selectedColor))
                .setPositiveButton("确定", (dialog, selectedColor, allColors) -> cvBlur.setCardBackgroundColor(selectedColor))
                .setNegativeButton("取消", (dialog, which) -> {
                })
                .build()
                .show();
    }

    @OnClick({R.id.btn_pick_color, R.id.cv_blur})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_pick_color:
                pickColor();
                break;
            case R.id.cv_blur:

                new RxPermissions(this)
                        .request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE);


                break;
        }
    }

}
