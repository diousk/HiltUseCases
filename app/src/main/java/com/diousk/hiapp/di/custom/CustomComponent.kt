package com.diousk.hiapp.di.custom

import dagger.hilt.DefineComponent
import dagger.hilt.android.components.ApplicationComponent

@CustomScope
@DefineComponent(parent = ApplicationComponent::class)
interface CustomComponent

@DefineComponent.Builder
interface CustomComponentBuilder {
    // fun fooSeedData(@BindsInstance Foo foo): CustomComponentBuilder
    fun build(): CustomComponent
}