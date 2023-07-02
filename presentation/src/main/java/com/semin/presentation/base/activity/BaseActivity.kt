package com.semin.presentation.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData(savedInstanceState)
    }

    open fun initData(bundle: Bundle?) {}
}