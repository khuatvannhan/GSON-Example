package com.nhankv.gsonexample.data.model

import com.nhankv.gsonexample.data.STUDENT_1
import com.nhankv.gsonexample.data.STUDENT_2
import com.google.gson.annotations.SerializedName

class ListStudent {
    @SerializedName(STUDENT_1)
    lateinit var student1: Student

    @SerializedName(STUDENT_2)
    lateinit var student2: Student
}
