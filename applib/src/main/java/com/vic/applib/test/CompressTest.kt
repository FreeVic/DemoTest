package com.vic.applib.test

import android.graphics.Bitmap
import com.vic.applib.utils.LogUtil
import com.vic.applib.utils.appDir
import com.vic.applib.utils.compress.CompressorUtil
import com.vic.applib.utils.compress.OnCompressListener
import com.vic.lib.test.BaseTest
import java.io.File


/**
 * Created by Vic on 2017/7/3 0003.
 */
class CompressTest: BaseTest() {
    override fun doSubTest() {
        var file = File("$appDir/5.jpg")

        class List:OnCompressListener<File>{
            override fun onStart() {
                LogUtil.d("start compress 1")
            }

            override fun onSuccess(file: File?) {
                LogUtil.d("end compress 1")
            }

            override fun onError(e: Throwable?) {
            }

        }

        class ListenerBM:OnCompressListener<Bitmap>{
            override fun onStart() {
                LogUtil.d("start compress 1")
            }

            override fun onSuccess(t: Bitmap?) {
                if(t!=null) {
                    LogUtil.d("end compress 1")
                }else{
                    LogUtil.d("end compress 1 but bitmap is null")
                }

            }

            override fun onError(e: Throwable?) {
                LogUtil.d("end compress on error")
            }

        }
        CompressorUtil.CompressToBitmap(file,"test.jpg",ListenerBM())
    }

}