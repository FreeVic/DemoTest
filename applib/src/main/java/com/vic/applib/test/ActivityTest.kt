package com.vic.applib.test

import android.content.Context
import android.os.Environment
import android.os.StatFs
import android.util.Log
import com.vic.applib.GlobalApplication
import com.vic.applib.utils.UIUtil

/**
 * Created by Vic on 2017/6/29 0029.
 */
class ActivityTest {
    fun doTest():Unit{
        val test = JsonTest()
        test.doTest()
        println("screen size ${UIUtil.getScreenSize()[0]}*${UIUtil.getScreenSize()[1]}")
        println("start time "+ System.currentTimeMillis())
        println("start file size time "+getRomAvailableSize(GlobalApplication.getApplication()))
        println("end time "+System.currentTimeMillis())
    }

    fun getRomAvailableSize(context: Context): Long {
        val path = Environment.getDataDirectory()
        val stat = StatFs(path.path)
        val blockSize = stat.blockSize.toLong()
        val availableBlocks = stat.availableBlocks.toLong()
        Log.i("info", "size=" + blockSize * availableBlocks / (1024 * 1024) + "MB")
        return blockSize * availableBlocks
        //        return Formatter.formatFileSize(context, blockSize * availableBlocks);
    }
}