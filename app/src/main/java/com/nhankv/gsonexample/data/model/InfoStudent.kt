package com.nhankv.gsonexample.data.model

class InfoStudent(builder: Builder) {
    var key: String = builder.key

    var value: String = builder.value

    class Builder {
        var key: String = ""

        var value: String = ""

        fun setKey(key: String): Builder {
            this.key = key
            return this
        }

        fun setValue(value: String): Builder {
            this.value = value
            return this
        }

        fun builder(): InfoStudent {
            return InfoStudent(this)
        }
    }
}
