package com.semin.presentation.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import com.semin.presentation.base.viewmodel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class MVIActivity<Binding : ViewDataBinding, State, Event>(@LayoutRes private val layoutId: Int) :
    BindActivity<Binding>(layoutId) {

    abstract val viewModel: BaseViewModel<State, Event>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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