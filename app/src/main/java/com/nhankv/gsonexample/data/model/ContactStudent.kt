package com.nhankv.gsonexample.data.model

import com.nhankv.gsonexample.data.model.Student
import com.google.gson.annotations.JsonAdapter
import com.nhankv.gsonexample.adapter.ForeignKeyTypeAdapterFactory

class ContactStudent {
    lateinit var bestFriend: Student
    
    @JsonAdapter(ForeignKeyTypeAdapterFactory::class)
    lateinit var goodFriend: Student
}
