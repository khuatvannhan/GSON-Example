package com.nhankv.gsonexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nhankv.gsonexample.customgson.CustomDeserialization
import com.nhankv.gsonexample.customgson.CustomDeserializationItf
import com.nhankv.gsonexample.customgson.CustomSerialization
import com.nhankv.gsonexample.customgson.CustomSerializationItf
import com.nhankv.gsonexample.data.ParseJson
import com.nhankv.gsonexample.data.ParseStudentItf

class MainActivity : AppCompatActivity() {
    private val TAG = javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testParseJsonByGson()
        testCustomSerialization()
        testCustomDeserialization()
//        val gson  = Gson()
//        val ints:IntArray = intArrayOf(1, 2, 3, 4, 5)
//        val strings = listOf("abc", "def", "ghi")
//        val jsonInt = gson.toJson(ints)
//
//        val jsonString = gson.toJson(strings)
//        Log.e(TAG,"json integer = $jsonInt")
//        Log.e(TAG,"json string = $jsonString")
//        val ints2 = gson.fromJson(jsonInt, IntArray::class.java)
//        System.out.println(ints2)
    }

    private fun testParseJsonByGson() {
        val parseJson: ParseStudentItf = ParseJson()
        parseJson.parseJsonArray()
        parseJson.parseJsonObject()
    }

    private fun testCustomSerialization() {
        val customSerializationItf: CustomSerializationItf =
            CustomSerialization()
        customSerializationItf.customSerializationAsSingleObject()
        customSerializationItf.customSerializationWithAnnotation()
    }

    private fun testCustomDeserialization() {
        val customDeserializationItf: CustomDeserializationItf = CustomDeserialization()
        customDeserializationItf.customDeserialization()
    }
}
