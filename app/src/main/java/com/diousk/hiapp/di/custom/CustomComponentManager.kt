package com.diousk.hiapp.di.custom

import android.util.Log
import com.diousk.hiapp.deps.CustomDep
import dagger.hilt.EntryPoints
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CustomComponentManager @Inject constructor(
    private val componentBuilder: CustomComponentBuilder
) {

    private var component: CustomComponent? = null

    fun init() {
        component = componentBuilder.build()
    }

    fun getDep(): CustomDep {
        val entryPoint = EntryPoints.get(component, CustomEntryPoint::class.java)
        Log.d("CustomComponentManager", "entryPoint = $entryPoint")
        return entryPoint.getCustomDep()
    }

    fun clear() {
        component = null
    }
}