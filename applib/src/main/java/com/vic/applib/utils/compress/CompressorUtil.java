package com.vic.applib.utils.compress;

import android.graphics.Bitmap;

import com.vic.applib.GlobalApplication;
import com.vic.applib.utils.ConfigInfo;
import com.vic.applib.utils.UIUtil;

import java.io.File;
import java.util.HashMap;

import static com.vic.applib.utils.compress.CompressorUtil.CompressType.COMPRESS_JPEG;

/**
 * Image Compress Util
 * Created by zhangshengli on 2016/11/17.
 */

public class CompressorUtil {
    public enum CompressType{
        COMPRESS_SMALL(UIUtil.getScreenSize()[0]*1/3,UIUtil.getScreenSize()[1]*1/3,75,Bitmap.CompressFormat.PNG),
        COMPRESS_MIDDLE(UIUtil.getScreenSize()[0]*1/2,UIUtil.getScreenSize()[1]*1/2,75,Bitmap.CompressFormat.PNG),
        COMPRESS_DEFAULT(UIUtil.getScreenSize()[0],UIUtil.getScreenSize()[1],75, Bitmap.CompressFormat.PNG),
        COMPRESS_JPEG(UIUtil.getScreenSize()[0],UIUtil.getScreenSize()[1],100, Bitmap.CompressFormat.JPEG);
        float maxWidth;
        float maxHeight;
        int quality;
        Bitmap.CompressFormat compressType;

        CompressType(float maxWidth, float maxHeight, int quality, Bitmap.CompressFormat compressType) {
            this.maxWidth = maxWidth;
            this.maxHeight = maxHeight;
            this.quality = quality;
            this.compressType = compressType;
        }

        public float getMaxWidth() {
            return maxWidth;
        }

        public float getMaxHeight() {
            return maxHeight;
        }

        public int getQuality() {
            return quality;
        }

        public Bitmap.CompressFormat getCompressType() {
            return compressType;
        }


    }
    private static HashMap<CompressType,Compressor> map = new HashMap<>();
    private static Compressor getCompressor(CompressType type) {
        Compressor compressor = map.get(type);
        if(compressor ==null){
            compressor = new Compressor.Builder(GlobalApplication.getApplication()).setMaxWidth(type.getMaxWidth())
                    .setMaxHeight(type.getMaxHeight())
                    .setQuality(type.getQuality())
                    .setCompressFormat(type.getCompressType())
                    .setDestinationDirectoryPath(ConfigInfo.Config.getPicDir())
                    .build();
            map.put(type,compressor);
        }
        return compressor;
    }

    public static File compressToFile(File file,CompressType type) {
        if (null == file || !file.exists())
            return null;
        return getCompressor(type).compressToFile(file);
    }

    public static File compressToFile(File file,CompressType type,String expectName) {
        if (null == file || !file.exists())
            return null;
        return getCompressor(type).compressToFile(file,expectName);
    }

    public static File compressToFile(File file) {
        if (null == file || !file.exists())
            return null;
        File newFile = getCompressor(COMPRESS_JPEG).compressToFile(file);
        return newFile;
    }

    public static File compressToFile(File file,String expectName) {
        if (null == file || !file.exists())
            return null;
        File newFile = getCompressor(COMPRESS_JPEG).compressToFile(file,expectName);
        return newFile;
    }

    public static Bitmap compressToBitmap(File file,CompressType type) {
        if (null == file || !file.exists())
            return null;
        return getCompressor(type).compressToBitmap(file);
    }
}
