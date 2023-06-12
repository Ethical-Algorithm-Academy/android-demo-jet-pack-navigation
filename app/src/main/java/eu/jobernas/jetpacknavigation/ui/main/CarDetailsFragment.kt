package eu.jobernas.jetpacknavigation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import eu.jobernas.jetpacknavigation.databinding.FragmentDetailsCarBinding
import eu.jobernas.jetpacknavigation.models.Vehicle

class CarDetailsFragment : Fragment() {

    companion object {
        private const val KEY_SELECT_CAR = "KEY_SELECT_CAR"
        fun getBundle(selectVehicle: Vehicle): Bundle =
            Bundle().apply {
                putParcelable(KEY_SELECT_CAR, selectVehicle)
            }
    }

    private var binding: FragmentDetailsCarBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val selectVehicle = arguments?.getParcelable<Vehicle>(KEY_SELECT_CAR)
        binding = FragmentDetailsCarBinding.inflate(inflater, container, false)
        binding?.apply {
            if (selectVehicle != null){
                carDetailsModelTextView.text = "${selectVehicle.name}, ${selectVehicle.brand}"
            }
        }
        return binding?.root
    }
}