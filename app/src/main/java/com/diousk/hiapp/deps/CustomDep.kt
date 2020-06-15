package com.diousk.hiapp.deps

import android.util.Log
import javax.inject.Inject

interface CustomDep

class CustomDepImpl @Inject constructor() : CustomDep {
    init {
        Log.d("CustomDepImpl", "init this = $this")
    }
}

class CustomDepImpl2 @Inject constructor() : CustomDep {
    init {
        Log.d("CustomDepImpl2", "init this = $this")
    }
}