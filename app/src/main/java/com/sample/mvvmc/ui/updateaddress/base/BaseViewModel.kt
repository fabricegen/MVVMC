package com.sample.mvvmc.ui.updateaddress.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.mvvmc.ui.updateaddress.address.AddressViewModel

open class BaseViewModel : ViewModel() {

    val events = MutableLiveData<AddressViewModel.EnterCoordinationEvent>()

    protected fun sendCoordinationEvent(event: AddressViewModel.EnterCoordinationEvent) {
        events.value = event
    }
}
