package com.nhankv.gsonexample.data

import android.util.Log
import com.nhankv.gsonexample.data.model.InfoStudent
import com.nhankv.gsonexample.data.model.ListStudent
import com.nhankv.gsonexample.data.model.Student
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class ParseJson : ParseStudentItf {
    private val TAG = javaClass.name

    override fun parseJsonArray(): ArrayList<Student> {
        val listStudent: ArrayList<Student> = arrayListOf()
        val jsonArray = JSONArray(JSON_ARRAY)
        val size = jsonArray.length() - 1
        for (i in 0..size) {
            val jsonOject = jsonArray.getJSONObject(i) // get JSONObject from index i
            val student = getStudentFromJSONObject(jsonOject)
            listStudent.add(student)
            Log.d("", listStudent.toString())
        }
        Log.e(TAG, "Convert object to json array value: = ${Gson().toJson(listStudent)}")
        return listStudent
    }

    override fun parseJsonObject(): ListStudent {
        val gson = Gson()
        val jObject = JSONObject(JSON_OBJECT)
        val listStudent = gson.fromJson(jObject.toString(), ListStudent::class.java) // convert json to ListStudent
        val student1 = jObject.getJSONObject(STUDENT_1)
        val student2 = jObject.getJSONObject(STUDENT_2)
        // get student1 and student2 to get infoStudent
        listStudent.student1.infoStudent = getInfoStudent(student1)
        listStudent.student2.infoStudent = getInfoStudent(student2)
        Log.e(TAG, "Convert object to json object value: = ${gson.toJson(listStudent)}")
        return listStudent
    }

    override fun getStudentFromJSONObject(jsonOject: JSONObject): Student {
        val student: Student
        val gson = Gson()
        student = gson.fromJson(jsonOject.toString(), Student::class.java) // convert json to object Student.class
        student.infoStudent = getInfoStudent(jsonOject)
        return student
    }

    override fun getInfoStudent(jObject: JSONObject): InfoStudent {
        val jInfo = jObject.getJSONObject(INFO_STUDENT)
        val key = jInfo.keys().next() // find key
        val value = jInfo.getString(key) //get value by key
        val infoStudent = InfoStudent.Builder().setKey(key).setValue(value)
        return infoStudent.builder()
    }
}
