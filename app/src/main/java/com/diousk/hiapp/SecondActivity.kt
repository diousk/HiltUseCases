package com.diousk.hiapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.diousk.hiapp.deps.CustomDep
import com.diousk.hiapp.di.custom.CustomComponentManager
import com.diousk.hiapp.di.custom.CustomDep1
import com.diousk.hiapp.di.custom.CustomDep2
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondActivity: AppCompatActivity() {
    @Inject
    lateinit var customComponentManager: CustomComponentManager

    @Inject
    @CustomDep2
    lateinit var customDep2: CustomDep

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Second", "onCreate")
        setContentView(R.layout.activity_main)
        Log.d("Second", "custom dep = ${customComponentManager.getDep()}")
        Log.d("Second", "inject custom dep2 = $customDep2")
        customComponentManager.clear()
    }
}