package com.sample.mvvmc.ui.updateaddress.navigation

import com.sample.mvvmc.common.Screen

sealed class UpdateAddressScreen : Screen {
    object EnterAddress:
        UpdateAddressScreen()
    object Confirmation:
        UpdateAddressScreen()
}
