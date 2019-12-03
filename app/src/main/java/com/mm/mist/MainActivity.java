package com.mm.mist;

import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import androidx.cardview.widget.CardView;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.iv_background) ImageView ivBackground;
    @BindView(R.id.iv_blur) ImageView iv_blur;
    @BindView(R.id.cv_blur) CardView cvBlur;
    @BindView(R.id.sb_alpha) SeekBar sbAlpha;
    @BindView(R.id.sb_test) SeekBar sb_test;
    @BindView(R.id.tv_test) TextView tv_test;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setSeekBarListener(sbAlpha, 1);
        setSeekBarListener(sb_test, 2);
//        BlurKit.init(this );
    }

    private void setSeekBarListener(SeekBar seekBar, int tag) {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                switch (tag) {
                    case 1:
                        BlurImgUtil.displayBlurImg(MainActivity.this, R.mipmap.ic_test, iv_blur, i);

//                     iv_blur.setAlpha((float) i / 100);
//                        Blurry.with(MainActivity.this)
//                                .radius(i)
//                                .sampling(8)
//                                .async()
//                                .onto(cvBlur);

                        break;
                    case 2:
                        iv_blur.setAlpha((float) i / 100);
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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

//                Blurry.with(this)
//                        .radius(55)
//                        .sampling(8)
//                        .async()
//                        .onto(cvBlur);
                //  BlurKit.getInstance().blur(cvBlur, 33);

//                Bitmap blurBitmap = BlurBitmapUtil.blurBitmap(this, image, 20);
//                cvBlur.setImageBitmap(blurBitmap);


                break;
        }
    }

}
