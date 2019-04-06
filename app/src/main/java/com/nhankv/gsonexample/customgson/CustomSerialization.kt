package com.nhankv.gsonexample.customgson

import android.util.Log
import com.nhankv.gsonexample.customgson.CustomSerializationItf
import com.nhankv.gsonexample.data.AGE_STUDENT
import com.nhankv.gsonexample.data.model.ContactStudent
import com.nhankv.gsonexample.data.model.InfoStudent
import com.nhankv.gsonexample.data.model.Schools
import com.nhankv.gsonexample.data.model.Student
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.JsonSerializer


class CustomSerialization : CustomSerializationItf {
    private val TAG = javaClass.name

    private fun initDataToTest(): Schools {
        val student: Student = Student.Builder().
            setAge(33).
            setName("Lamaspeak").
            setInfoStudent(InfoStudent.Builder().
                setKey("123").
                setValue("321").
                builder()).
            builder()
        val student2 = Student.Builder().
            setAge(44).
            setName("Lamaspeak2").
            setInfoStudent(InfoStudent.Builder().
                setKey("456").
                setValue("654").
                builder()).
            builder()

        val listStudent = arrayListOf(student, student2)
        val schools = Schools()
        schools.address = "Huynh cung, tam hiep, thanh tri, HN"
        schools.schools = "Intermediate Vocational Shool No. 18 (Department of Defense)"
        schools.listStudent = listStudent
        return schools
    }

    override fun customSerializationAsSingleObject() {
        val schools = initDataToTest()
        val gsonBuilder = GsonBuilder()
        val serializer = JsonSerializer<Student> { src, typeOfSrc, context ->
            val jsonStudent = JsonObject()
            //Only show age of student
            jsonStudent.addProperty(AGE_STUDENT, src!!.age)
            jsonStudent
        }
        gsonBuilder.registerTypeAdapter(Student::class.java, serializer)
        val customGson = gsonBuilder.create()
        val customJson = customGson.toJson(schools)
        Log.e(TAG, "custom Json value: = $customJson")
        Log.d(TAG, "---------------------------------------")
    }

    override fun customSerializationWithAnnotation() {
        val student: Student = Student.Builder().
            setAge(33).
            setName("Lamaspeak").
            setInfoStudent(InfoStudent.Builder().
                setKey("123").
                setValue("321").
                builder()).
            builder()
        val student2 = Student.Builder().
            setAge(44).
            setName("Lamaspeak2").
            setInfoStudent(InfoStudent.Builder().
                setKey("456").
                setValue("654").
                builder()).
            builder()

        val contactStudent = ContactStudent()
        contactStudent.bestFriend = student
        contactStudent.goodFriend = student2
        val gson = Gson()
        Log.e(TAG, "custom serialization with annotation: = ${gson.toJson(contactStudent)}")
        Log.d(TAG, "---------------------------------------")
    }
}
