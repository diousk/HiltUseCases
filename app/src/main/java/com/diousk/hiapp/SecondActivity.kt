package com.diousk.hiapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.diousk.hiapp.di.CustomComponentManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondActivity: AppCompatActivity() {
    @Inject
    lateinit var customComponentManager: CustomComponentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Second", "onCreate")
        setContentView(R.layout.activity_main)
        Log.d("Main", "custom dep = ${customComponentManager.getDep()}")
        customComponentManager.clear()
    }
}