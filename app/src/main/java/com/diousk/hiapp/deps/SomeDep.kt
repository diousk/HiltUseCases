package com.diousk.hiapp.deps

import android.util.Log
import javax.inject.Inject

interface SomeDep

class SomeDepImpl @Inject constructor() : SomeDep {
    init {
        Log.d("SomeDepImpl", "init this = $this")
    }
}