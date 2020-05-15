package com.sample.mvvmc.ui.updateaddress.navigation

import com.sample.mvvmc.common.Coordinator
import com.sample.mvvmc.ui.updateaddress.address.AddressViewModel
import com.sample.mvvmc.common.BaseViewModel
import com.sample.mvvmc.navigation.FeatureNavigator
import com.sample.mvvmc.ui.updateaddress.confirmation.ConfirmationViewModel

class UpdateAddressCoordinator(private val flowNavigator: UpdateAddressFlowNavigator,
                               private val featureNavigator:FeatureNavigator) : Coordinator<UpdateAddressScreen> {
    override fun onStart() {
        flowNavigator.newRootScreen(UpdateAddressScreen.EnterAddress)
    }

    override fun onCreateViewModel(screen: UpdateAddressScreen): BaseViewModel {
        if (screen is UpdateAddressScreen.EnterAddress) {
            return AddressViewModel()
        } else if (screen is UpdateAddressScreen.Confirmation) {
            return ConfirmationViewModel()
        }
        return AddressViewModel()
    }

    override fun onEvent(event: Any, screen: UpdateAddressScreen) {
        when (event) {
            is AddressViewModel.EnterCoordinationEvent.AddressConfirmed -> {
                flowNavigator.navigateTo(UpdateAddressScreen.Confirmation, event.address)
            }
            is ConfirmationViewModel.ConfirmationCoordinationEvent.ConfirmationDone -> {
                featureNavigator.navigateToHome()
            }
        }
    }
}
