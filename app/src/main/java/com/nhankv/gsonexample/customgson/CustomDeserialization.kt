package com.nhankv.gsonexample.customgson

import android.util.Log
import com.nhankv.gsonexample.customgson.CustomDeserializationItf
import com.nhankv.gsonexample.data.JSON_USER_DATE
import com.nhankv.gsonexample.data.model.UserDate
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import java.util.*

class CustomDeserialization : CustomDeserializationItf {
    private val TAG = javaClass.name

    override fun customDeserialization(): UserDate {
        val gsonBuilder = GsonBuilder()
        val deserializer = JsonDeserializer { json, typeOfT, context ->
            val jsonObject = json.asJsonObject
            val date = Date(jsonObject.get("year").asInt, jsonObject.get("month").asInt, jsonObject.get("day").asInt)
            val userDate = UserDate.Builder().
                setAge(jsonObject.get("age").asInt).
                setEmail(jsonObject.get("email").asString).
                setIsDeveloper(jsonObject.get("isDeveloper").asBoolean).
                setName(jsonObject.get("name").asString).
                setRegisterDate(date).
                builder()
            userDate
        }
        gsonBuilder.registerTypeAdapter(UserDate::class.java, deserializer)

        val customGon = gsonBuilder.create()
        val customObjects = customGon.fromJson(JSON_USER_DATE, UserDate::class.java)
        Log.d(TAG, " custom deserialization $customObjects")
        return customObjects
    }
}
