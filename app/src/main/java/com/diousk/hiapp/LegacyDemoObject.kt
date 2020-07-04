package com.diousk.hiapp

import android.content.Context
import com.diousk.hiapp.deps.SomeDep
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import timber.log.Timber
import javax.inject.Inject

// use @EntryPoint for bridging legacy object with Hilt dependency graph
class LegacyDemoObject(private val context: Context) {
    @EntryPoint
    @InstallIn(ApplicationComponent::class)
    interface LegacyDemoEntryPoint {
        fun getSomeDep(): SomeDep
        fun inject(obj: LegacyDemoObject)
    }

    // we can have field injection after call inject() defined in LegacyDemoEntryPoint
    @Inject
    lateinit var someDep: SomeDep

    private val entryPoint by lazy {
        EntryPoints.get(context.applicationContext, LegacyDemoEntryPoint::class.java)
        // or use
        // EntryPointAccessors.fromApplication(context, LegacyObjectEntryPoint::class.java)
    }

    init {
        // both of the someDep are the same
        Timber.d("someDep1 = ${entryPoint.getSomeDep()}")
        entryPoint.inject(this)
        Timber.d("someDep2 = $someDep")
    }
}