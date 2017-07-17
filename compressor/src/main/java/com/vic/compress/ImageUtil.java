package com.vic.compress;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;

/**
 * Created by Vic on 2017/7/4 0004.
 */

public class ImageUtil {
    private ImageUtil(){}

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
            e.printStackTrace();
        }
        return null;
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
            e.printStackTrace();
        }
        return null;
    }
}
