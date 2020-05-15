package com.sample.mvvmc.navigation

import android.app.Activity
import com.sample.mvvmc.ui.updateaddress.UpdateAddressActivity

/*
 * Responsible to handle navigation between flows
 */
class FeatureNavigator(private val activity: Activity) {

    fun navigateToHome() {
        UpdateAddressActivity.launch(activity)
    }

}
