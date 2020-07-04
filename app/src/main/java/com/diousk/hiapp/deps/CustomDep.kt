package com.diousk.hiapp.deps

import timber.log.Timber
import javax.inject.Inject

interface CustomDep

class CustomDepImpl @Inject constructor() : CustomDep {
    init {
        Timber.d("init this = $this")
    }
}

class CustomDepImpl2 @Inject constructor() : CustomDep {
    init {
        Timber.d("init this = $this")
    }
}