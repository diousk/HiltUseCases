package com.diousk.hiapp.di

import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.android.components.ApplicationComponent
import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope
import javax.inject.Singleton

@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class CustomScope

@CustomScope
@DefineComponent(parent = ApplicationComponent::class)
interface CustomComponent

@DefineComponent.Builder
interface CustomComponentBuilder {
    // fun fooSeedData(@BindsInstance Foo foo): MyCustomComponentBuilder
    fun build(): CustomComponent
}