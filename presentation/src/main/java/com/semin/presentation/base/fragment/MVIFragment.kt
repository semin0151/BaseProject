package com.semin.presentation.base.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import com.semin.presentation.base.viewmodel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class MVIFragment<Binding : ViewDataBinding, State, Event>(@LayoutRes private val layoutId: Int) :
    BindFragment<Binding>(layoutId) {

    abstract val viewModel: BaseViewModel<State, Event>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        bind {
            lifecycleScope.launch(Dispatchers.Main) {
                viewModel.state.collect { state ->
                    render(state)
                }
            }
        }
    }

    protected abstract fun render(state: State)
}