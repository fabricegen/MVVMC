package com.sample.mvvmc.ui.updateaddress.confirmation

import com.sample.mvvmc.common.BaseViewModel
import com.sample.mvvmc.common.CoordinationEvent

class ConfirmationViewModel : BaseViewModel() {

    fun done() {
        sendCoordinationEvent(ConfirmationCoordinationEvent.ConfirmationDone)
    }

    sealed class ConfirmationCoordinationEvent: CoordinationEvent {
        object ConfirmationDone : ConfirmationCoordinationEvent()
    }
}
