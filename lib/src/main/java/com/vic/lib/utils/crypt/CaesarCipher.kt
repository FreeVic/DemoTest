package com.vic.lib.utils.crypt

/**
 * Created by eruser on 2017/12/7.
 */
class CaesarCipher {

    fun enCrypt(input:String,key:Int):String?{
        if(input.isNullOrEmpty())
            return null
        val sb = StringBuilder()
        input.toCharArray().forEach {
            sb.append((it.toInt()+key).toChar())
        }
        return sb.toString()
    }

    fun deCrypt(input:String,key:Int):String?{
        if(input.isNullOrEmpty())
            return null

        val sb = StringBuilder()
        input.toCharArray().forEach {
            sb.append((it.toInt()-key).toChar())
        }
        return sb.toString()
    }

}