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

   /* "f_call": "",
    "f_create_time": "2015-05-20 23:26:04",
    "f_crm_id": "226326275",
    "f_phone": "",
    "f_mobile": "15817115880",
    "f_modify_time": 1511750325,
    "f_tmp_id": [1, 0, 0, 0, 0],
    "f_title": "",
    "f_qq": "",
    "f_gender": "0",
    "f_name": "\u5468\u52c7",
    "f_user_id": "1011985",
    "f_email": "",
    "f_cs_guid": "0",
    "f_step": "0",
    "f_company_addr": "\u5e7f\u4e1c\u7701\u6df1\u5733\u5e02\u5357\u5c71\u533a\u6df1\u5357\u5927\u9053\u9760\u8fd1\u6df1\u5357\u6c99\u6cb3\u7acb\u4ea4",
    "f_company": "",
    "f_friend_id": "0",
    "f_type": "16",
    "f_classID": "0",
    "f_tagids": "80454320",
    "f_qq_id": 0,
    "f_face": "",
    "f_del": 0,
    "f_lnglat": "113.9584180000|22.5404760000"*/

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
        contact.f_lnglat = "113.9584180000|22.5404760000"
        contact.f_company_addr = "广东深深圳市康佳研发大厦20楼哈哈哈"
        contact.f_step = "2"
        contact.f_tmp_id = intArrayOf(1, 0, 0, 0, 0)
//        private var f_lnglat: String? = null
//        private var f_company_addr: String? = null
//        private var f_step: String? = null
//        private var f_tmp_id: String? = null
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
                .setFLnglat(contact.f_lnglat)
                .setFCompanyAddr(contact.f_company_addr)
                .setFStep(contact.f_step)
                .addAllFTmpId(contact.f_tmp_id.toMutableList())
                .build()
    }
}