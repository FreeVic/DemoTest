package com.vic.applib.test;

import com.vic.applib.utils.AsyncUtil;
import com.vic.applib.utils.ConfigInfoKt;
import com.vic.compress.Compressor;
import com.vic.lib.rx7.RxRunnable;
import com.vic.lib.test.BaseTest;

import java.io.File;

/**
 * Created by Vic on 2017/7/17 0017.
 */

public class CompressTest extends BaseTest {
    @Override
    protected void doSubTest() {
        final File file = new File(ConfigInfoKt.getAppDir() + "/6.jpg");
        AsyncUtil.runThread(new RxRunnable<File>() {
            @Override
            public File run() {
                return Compressor.getInstance().compressToFile(file,null);
            }

            @Override
            public void onUI(File file) {
                System.out.println("test compress");
            }

            @Override
            public void onError(Throwable error) {

            }
        });
    }
}
