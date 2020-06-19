package com.diousk.hiapp.deps

import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

interface SomeDep

class SomeDepImpl @Inject constructor() : SomeDep {
    init {
        Timber.d("init this = $this")
    }
}