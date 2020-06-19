package com.diousk.hiapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.diousk.hiapp.deps.SomeDep
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class ChildFragment: Fragment(R.layout.activity_main) {
    private val viewModel by viewModels<ChildViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("viewModel = $viewModel")
    }
}

class ChildViewModel @ViewModelInject constructor(
    private val someDep: SomeDep
): ViewModel() {
    init {
        Timber.d("some dep = $someDep")
    }
}