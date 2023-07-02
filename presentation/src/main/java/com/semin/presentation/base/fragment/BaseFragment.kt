package com.semin.presentation.base.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedInstanceState?.let { bundle ->
            initData(bundle)
        }
    }

    open fun initData(bundle: Bundle) {}
}