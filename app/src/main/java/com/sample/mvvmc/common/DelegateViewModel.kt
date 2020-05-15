package com.sample.mvvmc.common

import androidx.fragment.app.Fragment
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
