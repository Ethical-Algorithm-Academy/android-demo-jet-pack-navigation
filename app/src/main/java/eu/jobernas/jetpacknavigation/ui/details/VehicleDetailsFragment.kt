package eu.jobernas.jetpacknavigation.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import eu.jobernas.jetpacknavigation.R
import eu.jobernas.jetpacknavigation.databinding.FragmentDetailsVehicleBinding
import eu.jobernas.jetpacknavigation.models.Vehicle

class VehicleDetailsFragment : Fragment(), View.OnClickListener {

    companion object {
        private const val KEY_SELECTED_CAR = "SELECTED_CAR_KEY"

        /**
         * Old Way
         */
        fun newInstance(selectedVehicle: Vehicle) = VehicleDetailsFragment().apply {
            arguments = getBundle(selectedVehicle)
        }

        private fun getBundle(selectedVehicle: Vehicle): Bundle = Bundle().apply {
            putParcelable(KEY_SELECTED_CAR, selectedVehicle)
        }
    }

    private val args: CarDetailsFragmentArgs by navArgs()
    private var selectedVehicle: Vehicle? = null
    private var binding: FragmentDetailsVehicleBinding? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentDetailsVehicleBinding.inflate(inflater, container, false)
        selectedVehicle = args.selectedCar
        binding?.apply {
            vehicleDetailsMessageTextView.text =
                "${selectedVehicle?.name} + Color Int:${selectedVehicle?.color}"
            vehicleDetailsActionButton.setOnClickListener(this@VehicleDetailsFragment)
        }
        return binding?.root
    }

    /**
     * View.OnClickListener
     */
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.vehicle_details_action_button -> {
                //selectedVehicle?.name = "Changed Name"
                // TODO: Check this Example
//                findNavController().navigate(
//                    R.id.car_details_screen,
//                    CarDetailsFragmentArgs(selectedVehicle).toBundle(),
//                    NavigationConfig.defaultNavigationBuilder.build())
            }
        }

    }

}