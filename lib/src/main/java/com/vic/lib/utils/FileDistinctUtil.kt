package com.vic.lib.utils

import java.io.File

/**
 * Created by zhangshengli on 2017/11/6.
 */
object FileDistinctUtil {
    fun getDistinctFile(){
        val list = ArrayList<String>()
        getAllFile("app",list)
        getAllFile("configinfo",list)
        getAllFile("ecim",list)
        list.groupBy { it }.filter { it.value.size>1 }.forEach { s, _ -> println(s) }
    }

    private fun  getAllFile(s: String, list: ArrayList<String>) {
        var file = File("/Users/zhangshengli/Documents/work/as_workspace/EC2017/$s/src/main/java")
        getSubFiles(file,list)
    }

    private fun  getSubFiles(file: File, list: ArrayList<String>) {
        if(file.isDirectory){
            file.listFiles().forEach {
                if(it.isDirectory){
                    getSubFiles(it, list)
                }else{
                    list.add(it.name)
                }
            }
        }else{
            list.add(file.name)
        }
    }
}