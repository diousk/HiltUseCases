package com.diousk.hiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.diousk.hiapp.di.custom.CustomComponentManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var customComponentManager: CustomComponentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Main", "onCreate")
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        customComponentManager.init()
        Log.d("Main", "custom dep = ${customComponentManager.getDep()}")
        startActivity(Intent(this, SecondActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        })
    }
}
