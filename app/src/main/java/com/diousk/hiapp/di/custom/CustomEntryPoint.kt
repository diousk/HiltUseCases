package com.diousk.hiapp.di.custom

import com.diousk.hiapp.deps.CustomDep
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn

@EntryPoint
@InstallIn(CustomComponent::class)
interface CustomEntryPoint {
    fun getCustomDep(): CustomDep
}