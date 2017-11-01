package com.vic.applib.test

import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.serializer.SerializerFeature
import com.vic.applib.GlobalApplication
import com.vic.applib.proto.TestSize
import com.vic.applib.utils.AsyncUtil
import com.vic.lib.model.Contact
import com.vic.lib.model.ContactList
import com.vic.lib.rx7.RxRunnable
import com.vic.lib.test.BaseTest
import java.io.File

/**
 * Created by zhangshengli on 2017/10/26.
 */
class JsonTest : BaseTest() {
    override fun doSubTest() {
        AsyncUtil.runThread(object :RxRunnable<Any> {
            override fun run(): Any {
                writeJson()
                writePB()
                return Any()
            }

            override fun onUI(t: Any?) {
                println("write success")
            }

            override fun onError(error: Throwable?) {
            }

        })

//        testJson()
//        testPB()
    }

    fun testJson(){
        val open = GlobalApplication.getApplication().assets.open("hundred.json")
        val reader = open.reader(Charsets.UTF_8)
        val contactList = JSONObject.parseObject(reader.readText(), ContactList::class.javaObjectType)
        println(contactList.list.size)
    }

    fun testPB(){
        val open = GlobalApplication.getApplication().assets.open("hundred.pb")
        val readBytes = open.readBytes()
        val contactList = TestSize.ContactList.parseFrom(readBytes)
        println("contactlist = ${contactList.listCount}")
    }

    fun writeJson(){
        val contact = getJson()
        val arrayList = ArrayList<Contact>()
        var nums = 1..10000   //[1,100]
        for (num in nums) {
            arrayList.add(contact)
        }
        val contactList = ContactList()
        contactList.list.addAll(arrayList)
        JSONObject.toJSONString(contactList, SerializerFeature.DisableCircularReferenceDetect)
        val file = File("/sdcard/hundred.json")
        file.writeText(JSONObject.toJSONString(contactList, SerializerFeature.DisableCircularReferenceDetect))

    }

    fun writePB(){
        val contact = getJson()
        val arrayList = ArrayList<TestSize.Contact>()
        val pb = getPB(contact)
        var nums = 1..10000   //[1,100]
        for (num in nums) {
            arrayList.add(pb)
        }
        val contactList = TestSize.ContactList.newBuilder().addAllList(arrayList)
                .build()
        val file = File("/sdcard/hundred.pb")
        file.writeBytes(contactList.toByteArray())
    }

    fun getJson():Contact{
        var contact = Contact()
        contact.f_call = "称呼1111"
        contact.f_classID = "12"
        contact.f_company = "深圳市六度人和科技有限公司"
        contact.f_create_time ="2016-01-10 13:19:07"
        contact.f_crm_id ="297698748"
        contact.f_cs_guid ="297698748"
        contact.f_del =0
        contact.f_email ="zhangsl@ecqun.com"
        contact.f_face ="http://wiki.workec.com/pages/viewpage.action?pageId=5744823"
        contact.f_friend_id = "297698748"
        contact.f_gender = "1"
        contact.f_mobile = "13500000000"
        contact.f_modify_time = 1452403147
        contact.f_name = "新增1111"
        contact.f_phone = "13500000000"
        contact.f_qq = "45456767834"
        contact.f_qq_id = 355657678
        contact.f_tagids = "34545||34345||3435465||232344"
        contact.f_title = "测试1111"
        contact.f_type ="1"
        contact.f_user_id = "1791430"
        return contact
    }

    fun getPB(contact:Contact):TestSize.Contact{
        return TestSize.Contact.newBuilder()
                .setFCall(contact.f_call)
                .setFClassID(contact.f_classID)
                .setFCompany(contact.f_company)
                .setFCreateTime(contact.f_create_time)
                .setFCrmId(contact.f_crm_id)
                .setFCsGuid(contact.f_cs_guid)
                .setFDel(contact.f_del)
                .setFEmail(contact.f_email)
                .setFFace(contact.f_face)
                .setFFriendId(contact.f_friend_id)
                .setFGender(contact.f_gender)
                .setFMobile(contact.f_mobile)
                .setFModifyTime(contact.f_modify_time)
                .setFName(contact.f_name)
                .setFPhone(contact.f_phone)
                .setFQq(contact.f_qq)
                .setFQqId(contact.f_qq_id)
                .setFTagids(contact.f_tagids)
                .setFTitle(contact.f_title)
                .setFType(contact.f_type)
                .setFUserId(contact.f_user_id)
                .build()
    }
}