package com.sample.mvvmc.ui.updateaddress.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.sample.mvvmc.R
import com.sample.mvvmc.ui.updateaddress.address.AddressFragment
import com.sample.mvvmc.ui.updateaddress.confirmation.ConfirmationFragment
import com.sample.mvvmc.ui.updateaddress.model.Address

class UpdateAddressFlowNavigator(private val supportFragmentManager: FragmentManager) {

    fun newRootScreen(screen: UpdateAddressScreen) {
        if (screen is UpdateAddressScreen.EnterAddress) {
            replace(AddressFragment.newInstance())
        }
    }

    private fun replace(newFragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, newFragment)
            .commitNow()
    }

    fun navigateTo(screen: UpdateAddressScreen, arguments:Any?) {
        if (screen is UpdateAddressScreen.Confirmation) {
            replace(ConfirmationFragment.newInstance(arguments!! as Address))
        }
    }
}
