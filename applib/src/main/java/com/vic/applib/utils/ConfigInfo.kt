package com.vic.applib.utils

import android.os.Environment
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.nio.channels.FileChannel

/**
 * Created by Vic on 2017/7/3 0003.
 */
    val appDir:String = "${Environment.getExternalStorageDirectory().absolutePath}/DemoTest"
    val picDir:String = appDir+"/pic"

/**
 * 拷贝文件
 * @param source
 * *
 * @param dest
 * *
 * @throws IOException
 */
@Throws(IOException::class)
fun copyFile(source: File, dest: File) {
    var inputChannel: FileChannel? = null
    var outputChannel: FileChannel? = null
    try {
        inputChannel = FileInputStream(source).channel
        outputChannel = FileOutputStream(dest).channel
        outputChannel!!.transferFrom(inputChannel, 0, inputChannel!!.size())
    } finally {
        inputChannel!!.close()
        outputChannel!!.close()
    }
}