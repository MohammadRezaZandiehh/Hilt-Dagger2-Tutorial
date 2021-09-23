package com.example.hiltdagger2tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //filed Injection
//    @Inject
//    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        println(someClass.doAThing())


    }
}

@AndroidEntryPoint
class MyFragment : Fragment() {
    @Inject
    lateinit var someClass:SomeClass


}


@FragmentScoped
class SomeClass
@Inject
constructor(

) {

    fun doAThing(): String {
        return "Look i did a thing !"
    }
}