package com.diousk.hiapp.di.custom

import android.util.Log
import com.diousk.hiapp.deps.CustomDep
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
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
        // we can not just get CustomEntryPoint interface from
        // EntryPoints.get(applicationContext, CustomEntryPoint::class.java) nor
        // EntryPointAccessors.fromApplication(context, CustomEntryPoint::class.java)
        // because we install the CustomEntryPoint in the CustomComponent
        val entryPoint = EntryPoints.get(component, CustomEntryPoint::class.java)
        Log.d("CustomComponentManager", "entryPoint = $entryPoint")
        return entryPoint.getCustomDep()
    }

    fun clear() {
        component = null
    }

    @EntryPoint
    @InstallIn(CustomComponent::class)
    interface CustomEntryPoint {
        @CustomDep1 // qualifier
        fun getCustomDep(): CustomDep
    }
}