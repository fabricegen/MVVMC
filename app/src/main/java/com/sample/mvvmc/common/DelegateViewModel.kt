package com.sample.mvvmc.common

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.sample.mvvmc.navigation.Coordinator
import com.sample.mvvmc.navigation.CoordinatorHost
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class DelegateViewModel<T:Any> : ReadOnlyProperty<Screenable, T> {

    override operator fun getValue(thisRef: Screenable, property: KProperty<*>): T {
        val fragment = thisRef as Fragment
        val coordinatorHost = fragment.activity as CoordinatorHost
        val coordinator = coordinatorHost.coordinator as Coordinator<Screen>
        val viewModel = coordinator.onCreateViewModel(thisRef.screen)

        viewModel.events.observe( fragment.viewLifecycleOwner, Observer{
            coordinator.onEvent(it, thisRef.screen)
        })

        return viewModel as T
    }
}
