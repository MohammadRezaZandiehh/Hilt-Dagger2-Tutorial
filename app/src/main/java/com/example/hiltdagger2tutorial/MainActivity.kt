package com.example.hiltdagger2tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //filed Injection
    @Inject
    lateinit var someClass: someClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClass.doAThing())
    }
}

class  someClass
@Inject
constructor(){

    fun doAThing() :String{
        return "Look i did a thing !"
    }
}