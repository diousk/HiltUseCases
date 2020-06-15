package com.diousk.hiapp.di.custom

import com.diousk.hiapp.deps.CustomDep
import com.diousk.hiapp.deps.CustomDepImpl
import com.diousk.hiapp.deps.CustomDepImpl2
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Qualifier

@Module
@InstallIn(CustomComponent::class)
abstract class CustomModule {
    @Binds
    @CustomScope
    @CustomDep1
    abstract fun bindsCustomDep(impl: CustomDepImpl): CustomDep
}

// if we want activity class to inject CustomDep,
// it must be installed in ActivityComponent or ApplicationComponent (w/ or w/o scoped)
@Module
@InstallIn(ActivityComponent::class)
abstract class CustomModule2 {
    @Binds
    @CustomDep2
    abstract fun bindsCustomDep2(impl: CustomDepImpl2): CustomDep
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class CustomDep1

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class CustomDep2