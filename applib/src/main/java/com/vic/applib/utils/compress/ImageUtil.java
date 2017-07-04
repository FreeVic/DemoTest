package com.vic.applib.utils.compress;

import com.vic.applib.utils.AsyncUtil;
import com.vic.lib.rx7.RxRunnable;

import java.io.File;

/**
 * Created by Vic on 2017/7/4 0004.
 */

public class ImageUtil {
    private ImageUtil(){}
    public static void getScaledBitmap(final String src, final String dst, final OnCompressListener listener){
        AsyncUtil.runThread(new RxRunnable<File>() {
            @Override
            public File run() {
                try {
                    File srcFile = new File(src);
                    File dstFile = new File(dst);
                    Engine engine = new Engine(srcFile, dstFile);
                    if(listener!=null)
                        listener.onStart();
                    return engine.compress();
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
        });
    }
}
