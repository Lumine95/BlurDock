package com.mm.mist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by ZMM on 2019/12/3  17:05.
 */
public class BlurImgUtil {
    @SuppressLint("CheckResult")
    public static void displayBlurImg(Context context, Integer resourceId, ImageView imageView,int radius) {
        // "23":模糊度；"4":图片缩放4倍后再进行模糊

        List<Transformation<android.graphics.Bitmap>> list = new ArrayList<>();
        list.add(new BlurTransformation(radius, 4));
        list.add(new RoundedCornersTransformation(44,0));
        MultiTransformation<android.graphics.Bitmap> multiTransformation = new MultiTransformation<>(list);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.transform(multiTransformation);

//        RequestOptions requestOptions = new RequestOptions();
//        requestOptions.bitmapTransform(new BlurTransformation(23, 4));

        Bitmap bitmap = Bitmap.createBitmap(33, 33,
                Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(Color.parseColor("#FFFFFF"));//填充颜色


        Glide.with(context)
                .load(bitmap)
                .apply(requestOptions)
                .into(imageView);
    }

}
