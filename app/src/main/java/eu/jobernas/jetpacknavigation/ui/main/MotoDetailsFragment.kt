package eu.jobernas.jetpacknavigation.ui.main

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import eu.jobernas.jetpacknavigation.R
import eu.jobernas.jetpacknavigation.databinding.FragmentDetailsMotoBinding
import eu.jobernas.jetpacknavigation.helpers.NavigationConfig
import eu.jobernas.jetpacknavigation.models.Vehicle

class MotoDetailsFragment: Fragment(),
    View.OnClickListener {

    companion object {
        fun newInstance() = MotoDetailsFragment()
    }

    val args: MotoDetailsFragmentArgs by navArgs()
    var selectedVehicle: Vehicle? = null
    private var binding: FragmentDetailsMotoBinding? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        selectedVehicle = args.selectedCar
        binding = FragmentDetailsMotoBinding.inflate(inflater, container, false)
        binding?.apply {
            motoDetailsModelTextView.text = "${selectedVehicle?.name} + Number:${selectedVehicle?.color}"
            motoDetailsActionButton.setOnClickListener(this@MotoDetailsFragment)
        }
        return binding?.root
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.moto_details_action_button -> {
                // New Way
                val selectedVehicle = Vehicle("Auris", Color.RED, "Toyota")

//                val action = FragmentADirections.actionFragmentAToFragmentB(selectedCar)
//                v.findNavController().navigate(action, navOptions)

                // Old Way
//                v.findNavController().navigate(R.id.action_fragmentA_to_fragmentB, FragmentB.getBundle(selectedCar))
                // OR
//                v.findNavController().navigate(R.id.fragmentB, FragmentB.getBundle(selectedCar), navOptions)
                // OR
                findNavController().navigate(
                        R.id.moto_details_screen,
                        MotoDetailsFragmentArgs(selectedVehicle).toBundle(),
                        NavigationConfig.defaultNavigationBuilder.build())
            }
        }
    }

}