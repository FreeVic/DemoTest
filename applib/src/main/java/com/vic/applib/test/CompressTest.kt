package com.vic.applib.test

import com.vic.applib.utils.ConfigInfo
import com.vic.applib.utils.compress.CompressorUtil
import com.vic.lib.test.BaseTest
import java.io.File

/**
 * Created by Vic on 2017/7/3 0003.
 */
class CompressTest: BaseTest() {
    override fun doSubTest() {
        var file = File("${ConfigInfo.appDir}/1.jpg")
        CompressorUtil.compressToFile(file,CompressorUtil.CompressType.COMPRESS_JPEG,"2")
    }

}