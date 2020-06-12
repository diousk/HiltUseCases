package com.diousk.hiapp.di

import android.util.Log
import com.diousk.hiapp.deps.CustomDep
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import javax.inject.Inject
import javax.inject.Singleton

@EntryPoint
@InstallIn(CustomComponent::class)
interface CustomEntryPoint {
    fun getCustomDep(): CustomDep
}

@Singleton
class CustomComponentManager @Inject constructor(
    private val componentBuilder: CustomComponentBuilder
) {

    var component: CustomComponent? = null
        private set

    fun init() {
        component = componentBuilder.build()
    }

    fun getDep()= EntryPoints.get(component, CustomEntryPoint::class.java).getCustomDep()

    fun clear() {
        component = null
    }
}