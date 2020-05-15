package com.sample.mvvmc.ui.updateaddress

sealed class UpdateAddressScreen {
    object EnterAddress:UpdateAddressScreen()
    object Confirmation:UpdateAddressScreen()
}
