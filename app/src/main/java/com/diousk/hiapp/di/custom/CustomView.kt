package com.diousk.hiapp.di.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.diousk.hiapp.deps.SomeDep
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    attr: Int = 0
) : FrameLayout(context, attrs, attr) {

    @Inject lateinit var someDep: SomeDep

    init {
        Timber.d("init with someDep $someDep")
    }
}