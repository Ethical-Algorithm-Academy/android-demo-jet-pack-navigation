package eu.jobernas.jetpacknavigation.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import eu.jobernas.jetpacknavigation.databinding.FragmentDetailsCarBinding
import eu.jobernas.jetpacknavigation.models.Vehicle

class CarDetailsFragment : Fragment() {

    companion object {
        private const val KEY_SELECT_CAR = "KEY_SELECT_CAR"
        fun getBundle(selectVehicle: Vehicle): Bundle = Bundle().apply {
            putParcelable(KEY_SELECT_CAR, selectVehicle)
        }
    }

    private val args: CarDetailsFragmentArgs by navArgs()
    private var binding: FragmentDetailsCarBinding? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val selectVehicleFromArguments = arguments?.getParcelable<Vehicle>(KEY_SELECT_CAR)
        val selectVehicleFromNavArgs = args.selectedCar
        binding = FragmentDetailsCarBinding.inflate(inflater, container, false)
        binding?.apply {
            when {
                selectVehicleFromArguments != null -> carDetailsModelTextView.text =
                    "${selectVehicleFromArguments.name}, ${selectVehicleFromArguments.brand}"
                selectVehicleFromNavArgs != null -> carDetailsModelTextView.text =
                    "${selectVehicleFromNavArgs.name}, ${selectVehicleFromNavArgs.brand}"
            }
        }
        return binding?.root
    }
}