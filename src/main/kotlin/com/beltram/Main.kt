package com.beltram

inline fun <reified U> U.myName(): String = U::class.simpleName ?: "simpleName"

class User<out T>() {

    companion object {
        // this works
        private val myName = myName()
    }

    // this FAILS
    // with Type checking has run into a recursive problem. Easiest workaround: specify types of your declarations explicitly
    private val myName = myName()

    // this works with explicit type
    private val myName: String = myName().invoke()

    // this works
    private val myOtherName = myName()

//    this works
//    (either public or internal or protected) val myName = myName()
}

class Person<T>() {
    // this works
    private val myName = myName()
}