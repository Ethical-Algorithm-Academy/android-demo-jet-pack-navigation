package eu.jobernas.jetpacknavigation.ui.action

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import eu.jobernas.jetpacknavigation.databinding.FragmentNavigationActionBinding
import eu.jobernas.jetpacknavigation.models.Car

class ActionNavigationFragment : Fragment() {

    companion object {

        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) = ActionNavigationFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentNavigationActionBinding.inflate(inflater, container, false)
        binding.apply {
            actionButton.setOnClickListener {
                val car = Car("12", "Auris", Color.RED, "Toyota", false)
                // Lets Use a Direction that Combines an Action and a Bundle Parameter
                val carDetailsDirections =
                    ActionNavigationFragmentDirections.actionActionNavScreenToCarDetailsScreen(car)
                findNavController().navigate(carDetailsDirections)
            }
        }
        return binding.root
    }
}