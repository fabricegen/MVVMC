package com.sample.mvvmc.navigation

import com.sample.mvvmc.common.BaseViewModel

interface Coordinator<S : Any> {

    fun onStart()

    fun onCreateViewModel(screen: S): BaseViewModel

    fun onEvent(event: Any, screen: S)
}
