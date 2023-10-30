package com.example.mynotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn = findViewById<Button>(R.id.addBtn)
        replaceView("homefrag")
       btn.setOnClickListener {
            replaceView("createfrag")
        }
    }
    fun replaceView(fragName:String){
        Log.d("hi","inside $fragName")

        when(fragName){
            "homefrag"->
                supportFragmentManager.beginTransaction().add(R.id.ll,HomeFragment()).commit()
            "createfrag"->
                supportFragmentManager.beginTransaction().replace(R.id.ll,CreateFragment()).commit()

        }
    }
}