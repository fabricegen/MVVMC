package com.sample.mvvmc.ui.updateaddress

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sample.mvvmc.R
import com.sample.mvvmc.common.Coordinator
import com.sample.mvvmc.common.CoordinatorHost
import com.sample.mvvmc.navigation.FeatureNavigator
import com.sample.mvvmc.ui.updateaddress.navigation.UpdateAddressCoordinator
import com.sample.mvvmc.ui.updateaddress.navigation.UpdateAddressFlowNavigator

class UpdateAddressActivity : AppCompatActivity(), CoordinatorHost {

    override val coordinator: Coordinator<*>
        get() = UpdateAddressCoordinator(
            UpdateAddressFlowNavigator(supportFragmentManager),
            // need to be injected as singleton
            FeatureNavigator(this)
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.update_address_activity)
        if (savedInstanceState == null) {
            coordinator.onStart()
        }
    }

    companion object {
        fun launch(activity:Activity){
            val intent = Intent(activity.applicationContext, UpdateAddressActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            activity.startActivity(intent)
        }
    }
}
