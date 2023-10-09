package eu.jobernas.jetpacknavigation.ui.details

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import eu.jobernas.jetpacknavigation.R
import eu.jobernas.jetpacknavigation.SharedMainViewModel
import eu.jobernas.jetpacknavigation.databinding.FragmentDetailsMotoBinding
import eu.jobernas.jetpacknavigation.helpers.NavigationConfig
import eu.jobernas.jetpacknavigation.models.Moto

class MotoDetailsFragment: Fragment(),
    View.OnClickListener {

    companion object {
        private val TAG = MotoDetailsFragment::class.java.simpleName
        fun newInstance() = MotoDetailsFragment()
    }

//    val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var sharedMainViewModel: SharedMainViewModel
    val args: MotoDetailsFragmentArgs by navArgs()
    var selectedMoto: Moto? = null
    var selectedMotoID: Int? = null
    private var binding: FragmentDetailsMotoBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Using args from Jetpack navArgs to get Arguments
        selectedMoto = args.selectedMoto
        selectedMotoID = args.selectedMotoID?.toIntOrNull()
        Log.i(TAG, "${args.selectedMoto?.brand}")
        // Accessing shared Main View Model from Activity, you can use this to share data between fragments and Activities
        sharedMainViewModel = ViewModelProvider(requireActivity())[SharedMainViewModel::class.java]
        sharedMainViewModel.apply {
            onDataChanged.observe(viewLifecycleOwner) {
                Log.i(TAG, "${it?.brand}")
            }
        }
        binding = FragmentDetailsMotoBinding.inflate(inflater, container, false)
        binding?.apply {
            if (selectedMoto != null) {
                motoDetailsModelTextView.text = "Model: ${selectedMoto?.name}, " +
                    "Color:${selectedMoto?.color}, " +
                    "Brand: ${selectedMoto?.brand}, " +
                    "is 4 Wheels: ${selectedMoto?.isFourWheels}"
            }
            if (selectedMotoID != null) {
                motoDetailsModelTextView.text = "Moto ID: ${selectedMotoID}"
            }
            motoDetailsActionButton.setOnClickListener(this@MotoDetailsFragment)
        }
        return binding?.root
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.moto_details_action_button -> {
                // New Way
                val selectedMoto = Moto("22","Auris", Color.RED, "Toyota", false)

//                val action = FragmentADirections.actionFragmentAToFragmentB(selectedCar)
//                v.findNavController().navigate(action, navOptions)

                // Old Way
//                v.findNavController().navigate(R.id.action_fragmentA_to_fragmentB, FragmentB.getBundle(selectedCar))
                // OR
//                v.findNavController().navigate(R.id.fragmentB, FragmentB.getBundle(selectedCar), navOptions)
                // OR
                findNavController().navigate(
                        R.id.moto_details_screen,
                        MotoDetailsFragmentArgs(selectedMoto, null).toBundle(),
                        NavigationConfig.defaultNavigationBuilder.build())
            }
        }
    }

}