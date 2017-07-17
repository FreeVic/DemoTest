package com.vic.compress;

import android.graphics.Bitmap;
import android.text.TextUtils;

import java.io.File;

public class Compressor {
    private static Compressor instance;
    private String destinationDirectoryPath;
    private static String defaultDestination = FileUtil.getDefaultDirectory();
    private Compressor() {
    }

    public static Compressor getInstance() {
        if (instance == null) {
            synchronized (Compressor.class) {
                if (instance == null) {
                    instance = new Compressor.Builder().setDestinationDirectoryPath(defaultDestination).build();
                }
            }
        }
        return instance;
    }

    public static void initCompressDirectory(String path){
        if(FileUtil.checkPath(path)){
            defaultDestination = path;
        }
    }

    public File compressToFile(File file,String expectName) {
        return ImageUtil.getScaledFile(file.getAbsolutePath(),getDstPath(file,expectName));
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
