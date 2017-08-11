package com.vic.applib.test;

import com.vic.applib.utils.ConfigInfoKt;
import com.vic.lib.test.BaseTest;
import com.zxy.tiny.Tiny;
import com.zxy.tiny.callback.FileCallback;

/**
 * Created by Vic on 2017/7/17 0017.
 */

public class CompressTest extends BaseTest {
    @Override
    protected void doSubTest() {
//        final File file = new File(ConfigInfoKt.getAppDir() + "/4.png");
//        AsyncUtil.runThread(new RxRunnable<File>() {
//            @Override
//            public File run() {
//                return Compressor.getInstance().compressToFile(file,null);
//            }
//
//            @Override
//            public void onUI(File file) {
//                System.out.println("test compress");
//            }
//
//            @Override
//            public void onError(Throwable error) {
//
//            }
//        });


        Tiny.FileCompressOptions options = new Tiny.FileCompressOptions();
        options.outfile = ConfigInfoKt.getPicDir()+"/hh.png";
        Tiny.getInstance().source(ConfigInfoKt.getAppDir() + "/4.png").asFile().withOptions(options).compress(new FileCallback() {
            @Override
            public void callback(boolean isSuccess, String outfile) {
                //return the compressed file path
                System.out.println(outfile);
            }
        });

    }
}
