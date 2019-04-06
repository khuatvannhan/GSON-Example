package com.nhankv.gsonexample.data

import com.nhankv.gsonexample.data.model.InfoStudent
import com.nhankv.gsonexample.data.model.ListStudent
import com.nhankv.gsonexample.data.model.Student
import org.json.JSONObject

interface ParseStudentItf {
    fun parseJsonArray(): ArrayList<Student>

    fun parseJsonObject(): ListStudent

    fun getStudentFromJSONObject(jsonOject: JSONObject): Student

    fun getInfoStudent(jObject: JSONObject): InfoStudent
}
