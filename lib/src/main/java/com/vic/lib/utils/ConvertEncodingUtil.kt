package com.vic.lib.utils

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File

/**
 * Created by eruser on 2018/2/7.
 */
class ConvertEncodingUtil(var inputPath:String,var outputPath:String) {
    var baseInput:String?=null
    var baseOutput:String?=null
    init {
        var inputFile = File(inputPath)
        if(inputFile.exists()){
            baseInput = inputPath
            baseOutput = outputPath+File.separator+inputFile.name
        }

    }

    fun convert(){
        convertGBK2UTF8(inputPath,outputPath)
    }

   private fun convertGBK2UTF8(inputPath: String,outputPath: String){
        val input = File(inputPath)
        if(!input.exists())
            return
        input.absolutePath.replace(input.parent,outputPath+input.name)

        if(input.isDirectory){
            input.listFiles().forEach {
                convertGBK2UTF8(it.path,outputPath)
            }
        }else{
            println("input.canonicalPath  ${input.canonicalPath}")
            println("input.absolutePath  ${input.absolutePath}")
            println("input.name  ${input.name}")
            println("input.path  ${input.path}")
            println("input.parent  ${input.parent}")

            convertFileGBK2UTF8(inputPath,outputPath)
        }

    }

    private fun convertFileGBK2UTF8(inputPath: String, outputPath: String) {
        var reader:BufferedReader? = null
        var writer:BufferedWriter? = null
        if(baseInput!=null && baseOutput!=null){
            var modifiedPath = inputPath.replace(baseInput!!,baseOutput!!)
            println("modifiedPath  $modifiedPath")
            try {
                val input = File(inputPath)
                val output = File(modifiedPath)
                if(!output.parentFile.exists())
                    output.parentFile.mkdirs()

                if(!input.exists())
                    return
                reader = input.bufferedReader(charset("GBK"))
                writer = output.bufferedWriter(Charsets.UTF_8)
                reader.use {readstr-> writer.use {it?.write(readstr?.readText()) } }
            }catch (e:Exception){

            }finally {
                reader?.close()
                reader = null
                writer?.close()
                writer = null
            }
        }

    }
}