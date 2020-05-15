package com.sample.mvvmc.common

interface Coordinator<S : Any> {

    fun onStart()

    fun onCreateViewModel(screen: S): BaseViewModel

    fun onEvent(event: Any, screen: S)
}
