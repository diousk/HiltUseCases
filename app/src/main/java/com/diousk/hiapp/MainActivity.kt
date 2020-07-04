package com.diousk.hiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.diousk.hiapp.deps.SomeDep
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var someDep: SomeDep

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.d("someDep $someDep")

        // demo for using @EntryPoint
        LegacyDemoObject(this)
    }
}

class MainViewModel @ViewModelInject constructor(
    private val someDep: SomeDep
): ViewModel() {
    init {
        Timber.d("some dep = $someDep")
    }
}
