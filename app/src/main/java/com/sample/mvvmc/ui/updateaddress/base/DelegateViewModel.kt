package com.sample.mvvmc.ui.updateaddress.base

import androidx.fragment.app.Fragment
import com.sample.mvvmc.common.Coordinator
import com.sample.mvvmc.common.CoordinatorHost
import com.sample.mvvmc.common.Screen
import com.sample.mvvmc.common.Screenable
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class DelegateViewModel<T : Any> : ReadOnlyProperty<Screenable, T> {

    override operator fun getValue(thisRef: Screenable, property: KProperty<*>): T {
        val coordinatorHost = (thisRef as Fragment).activity as CoordinatorHost
        val coordinator = coordinatorHost.coordinator as Coordinator<Screen>
        val viewModel = coordinator.onCreateViewModel(thisRef.screen)

        viewModel.events.observeForever {
            coordinator.onEvent(it, thisRef.screen)
        }

        return viewModel as T
    }
}
