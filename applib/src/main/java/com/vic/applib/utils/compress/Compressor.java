package com.vic.applib.utils.compress;

import android.graphics.Bitmap;
import android.text.TextUtils;

import com.vic.applib.utils.ConfigInfoKt;

import java.io.File;

public class Compressor {
    private static Compressor instance;
    private String destinationDirectoryPath;
    private Compressor() {
    }

    public static Compressor getInstance() {
        if (instance == null) {
            synchronized (Compressor.class) {
                if (instance == null) {
                    instance = new Compressor.Builder().setDestinationDirectoryPath(ConfigInfoKt
                            .getPicDir()).build();
                }
            }
        }
        return instance;
    }


    public void compressToFile(File file,String expectName,OnCompressListener listener) {
        ImageUtil.getScaledFile(file.getAbsolutePath(),getDstPath(file,expectName),listener);
    }

    public File compressToFile(File file,String expectName) {
        return ImageUtil.getScaledFile(file.getAbsolutePath(),getDstPath(file,expectName));
    }

    public void compressToBitmap(File file,String expectName,OnCompressListener listener){
        ImageUtil.getScaledBitmap(file.getAbsolutePath(),getDstPath(file,expectName),listener);
    }

    public Bitmap compressToBitmap(File file,String expectName) {
        return ImageUtil.getScaledBitmap(file.getAbsolutePath(),getDstPath(file,expectName));
    }

    private String getDstPath(File file,String expectName) {
        if(TextUtils.isEmpty(expectName))
            return destinationDirectoryPath+"/"+FileUtil.getFileName(file);
        return destinationDirectoryPath+"/"+expectName;
    }

    public static class Builder {
        private Compressor compressor;

        public Builder() {
            compressor = new Compressor();
        }

        public Builder setDestinationDirectoryPath(String destinationDirectoryPath) {
            compressor.destinationDirectoryPath = destinationDirectoryPath;
            return this;
        }

        public Compressor build() {
            return compressor;
        }
    }
}
