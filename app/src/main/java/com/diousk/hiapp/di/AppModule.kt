package com.diousk.hiapp.di

import com.diousk.hiapp.deps.SomeDep
import com.diousk.hiapp.deps.SomeDepImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModule {
    @Binds
    abstract fun bindsSomeDep(impl: SomeDepImpl): SomeDep
}