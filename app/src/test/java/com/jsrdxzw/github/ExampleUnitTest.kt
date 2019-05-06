package com.jsrdxzw.github

import com.jsrdxzw.github.common.no
import com.jsrdxzw.github.common.otherwise
import com.jsrdxzw.github.common.yes
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun testBoolean(){
        val test1:Int = true.yes {
            1
        }.otherwise {
            2
        }
        val test2:String = false.no {
            "123"
        }.otherwise {
            "haha"
        }
        val test3 = if (true) "21" else "44"
        println(test1)
        println(test2)
        println(test3)
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    fun getABoolean(): Boolean {
        return true
    }
}
