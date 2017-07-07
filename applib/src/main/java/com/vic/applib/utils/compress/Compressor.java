package com.vic.applib.utils.compress;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;

import java.io.File;

public class Compressor {
    private static volatile Compressor INSTANCE;
    private Context context;
    //max width and height values of the compressed image is taken as 612x816
    private String destinationDirectoryPath;

    private Compressor(Context context) {
        this.context = context;
        destinationDirectoryPath = context.getCacheDir().getPath() + File.pathSeparator + FileUtil.FILES_PATH;
    }

    public static Compressor getDefault(Context context) {
        if (INSTANCE == null) {
            synchronized (Compressor.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Compressor(context);
                }
            }
        }
        return INSTANCE;
    }


    public void compressToFile(File file,String expectName,OnCompressListener listener) {
        ImageUtil.getScaledFile(file.getAbsolutePath(),getDstPath(expectName),listener);
    }

    public File compressToFile(File file,String expectName) {
        return ImageUtil.getScaledFile(file.getAbsolutePath(),getDstPath(expectName));
    }

    public void compressToBitmap(File file,String expectName,OnCompressListener listener){
        ImageUtil.getScaledBitmap(file.getAbsolutePath(),getDstPath(expectName),listener);
    }

    public Bitmap compressToBitmap(File file,String expectName) {
        return ImageUtil.getScaledBitmap(file.getAbsolutePath(),getDstPath(expectName));
    }

    private String getDstPath(String expectName) {
        if(TextUtils.isEmpty(expectName))
            return destinationDirectoryPath+"/"+System.currentTimeMillis();
        return destinationDirectoryPath+"/"+expectName;
    }


    public static class Builder {
        private Compressor compressor;

        public Builder(Context context) {
            compressor = new Compressor(context);
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
