package com.nhankv.gsonexample.data.model

import com.google.gson.annotations.SerializedName

class Schools {
    @SerializedName("schools")
    var schools: String = ""

    @SerializedName("address")
    var address: String = ""

    @SerializedName("listStudent")
    var listStudent = ArrayList<Student>()
}
