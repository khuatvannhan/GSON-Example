package com.nhankv.gsonexample.data.model

import com.nhankv.gsonexample.data.AGE_STUDENT
import com.nhankv.gsonexample.data.INFO_STUDENT
import com.nhankv.gsonexample.data.NAME_STUDENT
import com.google.gson.annotations.SerializedName

class Student(var builder: Builder) {
    var name: String = builder.name
    var infoStudent: InfoStudent = builder.infoStudent
    var age: Int = builder.age
    
    class Builder {
        @SerializedName(NAME_STUDENT)
        var name: String = ""

        @SerializedName(AGE_STUDENT)
        var age: Int = 0

        @SerializedName(INFO_STUDENT)
        lateinit var infoStudent: InfoStudent

        fun setName(name: String): Builder {
            this.name = name
            return this
        }

        fun setAge(age: Int): Builder {
            this.age = age
            return this
        }

        fun setInfoStudent(infoStudent: InfoStudent): Builder {
            this.infoStudent = infoStudent
            return this
        }

        fun builder(): Student {
            return Student(this)
        }
    }
}
