package com.vic.applib.utils.compress;

import android.graphics.Bitmap;

import com.vic.applib.GlobalApplication;
import com.vic.applib.utils.ConfigInfoKt;

import java.io.File;

/**
 * Image Compress Util
 * Created by zhangshengli on 2016/11/17.
 */

public class CompressorUtil {
    private static CompressorUtil instance;

    public static CompressorUtil getInstance() {
        if (instance == null) {
            synchronized (CompressorUtil.class) {
                if (instance == null) {
                    instance = new CompressorUtil();
                }
            }
        }
        return instance;
    }


    private Compressor compressor;

    private CompressorUtil() {
        this.compressor = new Compressor.Builder(GlobalApplication.getApplication()).setDestinationDirectoryPath(ConfigInfoKt
                .getPicDir()).build();
    }

    public void compressToFile(File file, String expectName, OnCompressListener<File> listener) {
        compressor.compressToFile(file, expectName, listener);
    }

    public File compressToFile(File file, String expectName) {
        return compressor.compressToFile(file, expectName);
    }

    public void CompressToBitmap(File file, String expectName, OnCompressListener<Bitmap> listener) {
        compressor.compressToBitmap(file, expectName, listener);
    }

    public Bitmap CompressToBitmap(File file, String expectName) {
        return compressor.compressToBitmap(file, expectName);
    }


}
