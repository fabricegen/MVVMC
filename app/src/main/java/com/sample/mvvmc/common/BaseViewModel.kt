package com.sample.mvvmc.common

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.mvvmc.navigation.CoordinationEvent

open class BaseViewModel : ViewModel() {

    val events = MutableLiveData<CoordinationEvent>()

    protected fun sendCoordinationEvent(event: CoordinationEvent) {
        events.value = event
    }
}
