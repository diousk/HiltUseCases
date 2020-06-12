package com.diousk.hiapp.di

import com.diousk.hiapp.deps.CustomDep
import com.diousk.hiapp.deps.CustomDepImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn

@Module
@InstallIn(CustomComponent::class)
abstract class CustomModule {
    @Binds
    @CustomScope
    abstract fun bindsCustomDep(impl: CustomDepImpl): CustomDep
}