package com.sample.mvvmc.ui.updateaddress.address

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.sample.mvvmc.R
import com.sample.mvvmc.common.DelegateViewModel
import com.sample.mvvmc.common.Screenable
import com.sample.mvvmc.ui.updateaddress.navigation.UpdateAddressScreen
import com.sample.mvvmc.ui.updateaddress.model.Address

class AddressFragment : Fragment(), Screenable {

    companion object {
        fun newInstance() = AddressFragment()
    }

    override val screen =
        UpdateAddressScreen.EnterAddress

    private val viewModel: AddressViewModel by DelegateViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.update_address_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        view!!.findViewById<Button>(R.id.next).setOnClickListener {
            viewModel.next(Address("new address"))
        }
    }

}
