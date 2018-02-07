package com.vic.lib.utils

import java.io.*

/**
 * Created by eruser on 2018/2/7.
 */
class ConvertEncodingUtil(var inputPath:String,var outputPath:String) {
    init {
        var inputFile = File(inputPath)
        if(inputFile.exists()){
            var baseInput = inputFile.parent
            var baseOutput = outputPath+inputFile.name
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
        try {
            val input = File(inputPath)
            val output = File(outputPath)
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