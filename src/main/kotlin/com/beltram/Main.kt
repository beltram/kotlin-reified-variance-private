package com.beltram

inline fun <reified T> T.myName(): String = T::class.simpleName ?: "simpleName"

class User<out T>() {
    // this FAILS
    // with Type checking has run into a recursive problem. Easiest workaround: specify types of your declarations explicitly
    private val myName = myName()

    // this works
    private val myOtherName = myName()

//    this works
//    protected val myName = myName()
//
//    this works
//    internal val myName = myName()
//
//    this works
//    public val myName = myName()
}

class Person<T>() {
    // this works
    private val myName = myName()

//    this works
//    protected val myName = myName()
//
//    this works
//    internal val myName = myName()
//
//    this works
//    public val myName = myName()
}