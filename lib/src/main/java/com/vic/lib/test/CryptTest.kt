package com.vic.lib.test

import com.vic.lib.utils.crypt.CaesarCipher

/**
 * Created by eruser on 2017/12/7.
 */
class CryptTest:BaseTest(),Cryptable {
    val input = "welcome to Crypt world"
    val cipher = CaesarCipher()
    val className = cipher.javaClass.simpleName
    val key = 10
    override fun enCrypt() {
       println("$className enCrypt ->${cipher.enCrypt(input,key)}")
    }

    override fun deCrypt() {
        val code = cipher.enCrypt(input,key)
        println("$className enCrypt ->${cipher.deCrypt(code!!,key)}")
    }

    override fun doSubTest() {
        enCrypt()
        deCrypt()
    }
}