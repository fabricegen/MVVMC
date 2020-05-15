package com.sample.mvvmc.ui.updateaddress.confirmation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.sample.mvvmc.R
import com.sample.mvvmc.common.DelegateViewModel
import com.sample.mvvmc.common.Screenable
import com.sample.mvvmc.ui.updateaddress.model.Address
import com.sample.mvvmc.ui.updateaddress.navigation.UpdateAddressScreen

class ConfirmationFragment : Fragment(), Screenable {

    override val screen = UpdateAddressScreen.Confirmation

    private var address: Address? = null
    private val viewModel: ConfirmationViewModel by DelegateViewModel()

    companion object {
        private const val ARG_ADDRESS = "arg_address"

        fun newInstance(address: Address): ConfirmationFragment {
            val bundle = Bundle()
            bundle.putParcelable(ARG_ADDRESS, address)
            val fragment = ConfirmationFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        address = arguments?.getParcelable(ARG_ADDRESS)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.confirmation_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        address?.let {
            view!!.findViewById<TextView>(R.id.address).text = it.address
        }
    }

}
