package com.sample.mvvmc.ui.updateaddress.address

import com.sample.mvvmc.common.BaseViewModel
import com.sample.mvvmc.navigation.CoordinationEvent
import com.sample.mvvmc.ui.updateaddress.model.Address

class AddressViewModel : BaseViewModel() {

    fun next(address: Address) {
        sendCoordinationEvent(AddressCoordinationEvent.AddressConfirmed(address))
    }

    sealed class AddressCoordinationEvent :
        CoordinationEvent {
        data class AddressConfirmed(val address: Address) : AddressCoordinationEvent()
    }
}
