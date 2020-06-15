package com.diousk.hiapp.di.custom

import com.diousk.hiapp.deps.CustomDep
import com.diousk.hiapp.deps.CustomDepImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(CustomComponent::class, ActivityComponent::class)
abstract class CustomModule {
    @Binds
    @CustomScope
    abstract fun bindsCustomDep(impl: CustomDepImpl): CustomDep
}