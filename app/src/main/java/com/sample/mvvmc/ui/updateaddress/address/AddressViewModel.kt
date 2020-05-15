package com.sample.mvvmc.ui.updateaddress.address

import com.sample.mvvmc.ui.updateaddress.base.BaseViewModel
import com.sample.mvvmc.ui.updateaddress.model.Address

class AddressViewModel : BaseViewModel() {

    fun next(address: Address) {
        sendCoordinationEvent(
            EnterCoordinationEvent.AddressConfirmed(
                address
            )
        )
    }

    sealed class EnterCoordinationEvent {
        data class AddressConfirmed(val address: Address) : EnterCoordinationEvent()
    }
}
