package com.gao_jmessage.views;


import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Transformation;

import javax.xml.transform.Transformer;

/**
 * 创建时间: 2018/11/13
 * 创建人: GaoXiaoXiong
 * 功能描述:
 */
public class GrayTransformation implements Transformation {

    private float MAX_WIDTH, MIN_HEIGHT, MIN_WIDTH, MAX_HEIGHT = 0;
    private ImageView imageView;

    public GrayTransformation(float MAX_WIDTH, float MIN_WIDTH, float MAX_HEIGHT, float MIN_HEIGHT,ImageView imageView) {
        this.MAX_WIDTH = MAX_WIDTH;
        this.MIN_HEIGHT = MIN_HEIGHT;
        this.MIN_WIDTH = MIN_WIDTH;
        this.MAX_HEIGHT = MAX_HEIGHT;
        this.imageView = imageView;
    }

    @Override
    public Bitmap transform(Bitmap resource) {
        int imageWidth = resource.getWidth();
        int imageHeight = resource.getHeight();

        // 裁剪 bitmap
        float width, height;
        if (imageWidth > imageHeight) {
            if (imageWidth > MAX_WIDTH) {
                float temp = MAX_WIDTH / imageWidth * imageHeight;
                height = temp > MIN_HEIGHT ? temp : MIN_HEIGHT;
                width = MAX_WIDTH;
            } else if (imageWidth < MIN_WIDTH) {
                float temp = MIN_WIDTH / imageWidth * imageHeight;
                height = temp < MAX_HEIGHT ? temp : MAX_HEIGHT;
                width = MIN_WIDTH;
            } else {
                float ratio = imageWidth / imageHeight;
                if (ratio > 3) {
                    ratio = 3;
                }
                height = imageHeight * ratio;
                width = imageWidth;
            }
        } else {
            if (imageHeight > MAX_HEIGHT) {
                float temp = MAX_HEIGHT / imageHeight * imageWidth;
                width = temp > MIN_WIDTH ? temp : MIN_WIDTH;
                height = MAX_HEIGHT;
            } else if (imageHeight < MIN_HEIGHT) {
                float temp = MIN_HEIGHT / imageHeight * imageWidth;
                width = temp < MAX_WIDTH ? temp : MAX_WIDTH;
                height = MIN_HEIGHT;
            } else {
                float ratio = imageHeight / imageWidth;
                if (ratio > 3) {
                    ratio = 3;
                }
                width = imageWidth * ratio;
                height = imageHeight;
            }
        }

        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        params.width = (int) width;
        params.height = (int) height;
        imageView.setLayoutParams(params);
        Matrix matrix = new Matrix();
        float scaleWidth = width / imageWidth;
        float scaleHeight = height / imageHeight;
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(resource, 0, 0, imageWidth, imageHeight, matrix, true);

    }

    @Override
    public String key() {
        return null;
    }
}
