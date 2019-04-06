package com.nhankv.gsonexample.adapter

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import com.nhankv.gsonexample.data.model.Student
import java.io.IOException


class ForeignKeyTypeAdapterFactory : TypeAdapterFactory {
    override fun <T> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T>? {
        if (!Student::class.java.isAssignableFrom(type.rawType)) {
            return null
        }

        val defaultAdapter = gson.getAdapter(type)


        return Adapter(defaultAdapter) as TypeAdapter<T>
    }

    private class Adapter<T> internal constructor(private val defaultAdapter: TypeAdapter<T>) :
        TypeAdapter<T>() {

        @Throws(IOException::class)
        override fun write(out: JsonWriter, value: T) {
            val student = value as Student
            out.value(student.age.toLong())
        }

        @Throws(IOException::class)
        override fun read(`in`: JsonReader): T {
            return defaultAdapter.read(`in`)
        }
    }
}
