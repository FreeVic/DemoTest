package com.vic.applib.utils.compress;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.vic.applib.utils.AsyncUtil;
import com.vic.lib.rx7.RxRunnable;

import java.io.File;

/**
 * Created by Vic on 2017/7/4 0004.
 */

public class ImageUtil {
    private ImageUtil(){}
    public static void getScaledBitmap(final String src, final String dst, final OnCompressListener listener){
        AsyncUtil.runThread(new RxRunnable<Bitmap>() {
            @Override
            public Bitmap run() {
                try {
                    File srcFile = new File(src);
                    File dstFile = new File(dst);
                    if(listener!=null)
                        listener.onStart();
                    if(FileUtil.isTooSmall(srcFile)){
                        return BitmapFactory.decodeFile(srcFile.getAbsolutePath());
                    }else{
                        Engine engine = new Engine(srcFile, dstFile);
                        Bitmap result = engine.compressToBitmap();
                        return result;
                    }

                } catch (Exception e) {
                        if(listener!=null)
                            listener.onError(e);
                    }
                return null;
            }

            @Override
            public void onUI(Bitmap file) {
                if(listener!=null)
                    listener.onSuccess(file);
            }

            @Override
            public void onError(Throwable error) {
                if(listener!=null)
                    listener.onError(error);
            }
        });
    }

    public static Bitmap getScaledBitmap(String src, String dst){
        try {
            File srcFile = new File(src);
            File dstFile = new File(dst);
            if(FileUtil.isTooSmall(srcFile)){
                return BitmapFactory.decodeFile(srcFile.getAbsolutePath());
            }else{
                Engine engine = new Engine(srcFile, dstFile);
                Bitmap result = engine.compressToBitmap();
                return result;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void getScaledFile(final String src, final String dst, final OnCompressListener listener){
        AsyncUtil.runThread(new RxRunnable<File>() {
            @Override
            public File run() {
                try {
                    File srcFile = new File(src);
                    File dstFile = new File(dst);
                    if(listener!=null)
                        listener.onStart();
                    if(FileUtil.isTooSmall(srcFile)){
                        return srcFile;
                    }else{
                        Engine engine = new Engine(srcFile, dstFile);
                        File result = engine.compress();
                        return result;
                    }
                } catch (Exception e) {
                    if(listener!=null)
                        listener.onError(e);
                }
                return null;
            }

            @Override
            public void onUI(File file) {
                if(listener!=null)
                    listener.onSuccess(file);
            }

            @Override
            public void onError(Throwable error) {

            }
        });
    }

    public static File getScaledFile(String src,String dst){
        try {
            File srcFile = new File(src);
            File dstFile = new File(dst);
            if(FileUtil.isTooSmall(srcFile)){
                return srcFile;
            }else{
                Engine engine = new Engine(srcFile, dstFile);
                File result = engine.compress();
                return result;
            }
        } catch (Exception e) {
        }
        return null;
    }
}
