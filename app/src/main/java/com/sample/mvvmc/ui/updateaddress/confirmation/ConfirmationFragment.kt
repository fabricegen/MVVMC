package com.sample.mvvmc.ui.updateaddress.confirmation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sample.mvvmc.R
import com.sample.mvvmc.common.DelegateViewModel
import com.sample.mvvmc.common.Screenable
import com.sample.mvvmc.ui.updateaddress.navigation.UpdateAddressScreen

class ConfirmationFragment : Fragment(), Screenable {

    override val screen =
        UpdateAddressScreen.Confirmation

    companion object {
        fun newInstance() =
            ConfirmationFragment()
    }

    private val viewModel: ConfirmationViewModel by DelegateViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.confirmation_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
