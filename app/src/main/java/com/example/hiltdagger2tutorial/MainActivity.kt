package com.example.hiltdagger2tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //filed Injection
    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClass.doAThing())
        println(someClass.doSomeOtherThings())

    }
}

class SomeClass
@Inject
constructor(
    private val someOtherThing: SomeOtherThing
) {

    fun doAThing(): String {
        return "Look i did a thing !"
    }

    fun doSomeOtherThings(): String {
        return someOtherThing.doSomeOtherThings()
    }
}

class SomeOtherThing
@Inject
constructor() {

    fun doSomeOtherThings(): String {
        return "Look i did other things !"
    }

}