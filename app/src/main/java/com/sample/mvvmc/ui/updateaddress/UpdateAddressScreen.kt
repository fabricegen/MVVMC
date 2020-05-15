package com.sample.mvvmc.ui.updateaddress

import com.sample.mvvmc.common.Screen

sealed class UpdateAddressScreen : Screen {
    object EnterAddress:UpdateAddressScreen()
    object Confirmation:UpdateAddressScreen()
}
