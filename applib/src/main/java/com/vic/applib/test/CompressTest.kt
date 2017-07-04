package com.vic.applib.test

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
        var file = File("$appDir/4.png")

        class List:OnCompressListener{
            override fun onStart() {
                LogUtil.d("start compress 1")
            }

            override fun onSuccess(file: File?) {
                LogUtil.d("end compress 1")
            }

            override fun onError(e: Throwable?) {
            }

        }
        CompressorUtil.compressToFile(file,"test.jpg",List())
    }

}