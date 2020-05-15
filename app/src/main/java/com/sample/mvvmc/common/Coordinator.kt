package com.sample.mvvmc.common

import com.sample.mvvmc.ui.updateaddress.base.BaseViewModel

interface Coordinator<S : Any> {

    fun onStart()

    fun onCreateViewModel(screen: S): BaseViewModel

    fun onEvent(event: Any, screen: S)
}
