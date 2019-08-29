package com.smruti.kotlin.bootkotlindemo.utils

import kotlin.reflect.KProperty

//public static final values
const val userData = "daaata"

class Constants {
    companion object {
        //This is much less cleaner because under the hood, when bytecode is generated, a useless object is created
        const val title : String = "Smruti"
        //Even worse if you declare it as a val instead of a const
        // (compiler will generate a useless object + a useless function)
        val URL_PATH = "https://"

    }
    //Avoid using companion objects.
    // Behind the hood, getter and setter instance methods are created for the fields to be accessible.
    // Calling instance methods is technically more expensive than calling static methods.
    //Recommended practice :

    object DbConstants {
        const val TABLE_USER_ATTRIBUTE_DATA = "data"
    }

    //In kotlin, const can just hold primitive types.
    // If you want to pass a function to it, you need add the @JvmField annotation.
    // At compile time, it will be transform as a public static final variable.
    // But it's slower than with a primitive type.
    @JvmField val foo = Foo()

    private fun Foo() {
        println(URL_PATH)
    }

    var bar : String by lazy { "Smruti" }

    private lateinit var name : String;
}

private operator fun Any.setValue(constants: Constants, property: KProperty<*>, s: String) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}


