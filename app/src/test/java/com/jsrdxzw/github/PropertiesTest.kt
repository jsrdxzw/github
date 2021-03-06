package com.jsrdxzw.github

import com.jsrdxzw.github.common.PropertiesDelegate
import org.junit.Test

class InfoProps{
    private val prop = PropertiesDelegate("info.properties")
    var name:String by prop
    var email:String by prop
    var age:Int by prop
    var student: Boolean by prop
    var point: Float by prop
}

class TestProperties{
    @Test
    fun testProperties(){
        InfoProps().let {
            println(it.name)
            println(it.email)
            println(it.age)
            println(it.student)
            println(it.point)
            it.name = "kotlin"
        }
    }
}