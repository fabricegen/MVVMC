package com.sample.mvvmc.ui.updateaddress

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sample.mvvmc.common.Coordinator
import com.sample.mvvmc.common.CoordinatorHost
import com.sample.mvvmc.R

class UpdateAddressActivity : AppCompatActivity(),
    CoordinatorHost {

    override val coordinator: Coordinator<*>
        get() = UpdateAddressCoordinator(UpdateAddressFlowNavigator(supportFragmentManager))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.update_address_activity)
        if (savedInstanceState == null) {
            coordinator.onStart()
        }
    }
}
