package com.nhankv.gsonexample.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

class UserDate(builder: Builder) {
    var name: String = builder.name
    var email: String = builder.email
    var isDeveloper: Boolean = builder.isDeveloper
    var age: Int = builder.age

    class Builder {
        @SerializedName("name")
        var name: String = ""

        @SerializedName("email")
        var email: String = ""

        @SerializedName("isDeveloper")
        var isDeveloper: Boolean = false

        @SerializedName("age")
        var age: Int = 0

        @SerializedName("date")
        var registerDate: Date = Date()

        fun setName(name: String): Builder {
            this.name = name
            return this
        }

        fun setEmail(email: String): Builder {
            this.email = email
            return this
        }

        fun setIsDeveloper(isDeveloper: Boolean) : Builder {
            this.isDeveloper = isDeveloper
            return this
        }

        fun setAge(age: Int) : Builder {
            this.age = age
            return this
        }

        fun setRegisterDate(date: Date) : Builder {
            this.registerDate = date
            return this
        }

        fun builder(): UserDate {
            return UserDate(this)
        }
    }
}
