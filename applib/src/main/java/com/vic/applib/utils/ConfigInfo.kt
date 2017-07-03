package com.vic.applib.utils

import android.os.Environment

/**
 * Created by Vic on 2017/7/3 0003.
 */
class ConfigInfo{
companion object Config{
    val appDir:String = "${Environment.getExternalStorageDirectory().absolutePath}/DemoTest"
    val picDir:String = appDir+"/pic"
}
}