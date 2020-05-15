package com.sample.mvvmc.ui.updateaddress

import com.sample.mvvmc.common.Coordinator
import com.sample.mvvmc.ui.updateaddress.address.AddressViewModel
import com.sample.mvvmc.ui.updateaddress.base.BaseViewModel
import com.sample.mvvmc.ui.updateaddress.confirmation.ConfirmationViewModel

class UpdateAddressCoordinator(private val flowNavigator: UpdateAddressFlowNavigator) :
    Coordinator<UpdateAddressScreen> {
    override fun onStart() {
        flowNavigator.newRootScreen(UpdateAddressScreen.EnterAddress)
    }

    override fun onCreateViewModel(screen: UpdateAddressScreen): BaseViewModel {
        if (screen is UpdateAddressScreen.EnterAddress) {
            return AddressViewModel()
        } else if (screen is UpdateAddressScreen.EnterAddress) {
            return ConfirmationViewModel()
        }
        return AddressViewModel()
    }

    override fun onEvent(event: Any, screen: UpdateAddressScreen) {
        when (event) {
            is AddressViewModel.EnterCoordinationEvent.AddressConfirmed -> {
                flowNavigator.navigateTo(UpdateAddressScreen.Confirmation)
            }
        }
    }
}
