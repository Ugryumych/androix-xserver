
package net.homeip.ofn.androix;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import android.util.Log;

/* 2d version */

public class AndroiXBlitView extends View {
    private Bitmap mBitmap = null;

    public AndroiXBlitView(Context context) {
        super(context);

        int W = 800;
        int H = 480;

//        mBitmap = Bitmap.createBitmap(W, H, Bitmap.Config.RGB_565);

    }

    public int initFramebuffer(int width, int height, int depth) {
        Log.d("AndroiX", "Initialize Framebuffer: " + width + " x " + height + " depth: " + depth);
        if (depth != 16) {
            Log.d("AndroiX", "Bad depth: " + depth);
            return -1;
        }
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        return 0;
    }

    @Override protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmap, 0, 0, null);
        invalidate();
    }
}

