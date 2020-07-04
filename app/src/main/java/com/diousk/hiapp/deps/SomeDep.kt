package com.diousk.hiapp.deps

import timber.log.Timber
import javax.inject.Inject

interface SomeDep

class SomeDepImpl @Inject constructor() : SomeDep {
    init {
        Timber.d("init this = $this")
    }
}