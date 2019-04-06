package com.nhankv.gsonexample.customgson

import com.nhankv.gsonexample.data.model.UserDate

interface CustomDeserializationItf {
    fun customDeserialization(): UserDate
}
