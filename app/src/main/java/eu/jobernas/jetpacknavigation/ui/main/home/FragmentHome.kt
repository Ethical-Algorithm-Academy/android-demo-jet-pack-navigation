package eu.jobernas.jetpacknavigation.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import eu.jobernas.jetpacknavigation.R
import eu.jobernas.jetpacknavigation.databinding.FragmentHomeBinding
import eu.jobernas.jetpacknavigation.helpers.NavigationConfig
import eu.jobernas.jetpacknavigation.models.Car
import eu.jobernas.jetpacknavigation.ui.main.b.FragmentBArgs

class FragmentHome : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = FragmentHome()
    }

    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding?.actionB?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.actionB -> {
                // New Way
                val selectedCar = Car("This is a car from Home Screen", 1000)
                // With Segues
//                val action = FragmentADirections.actionFragmentAToFragmentB(selectedCar)
//                v.findNavController().navigate(action)

                // Compatible with Old Way
                v.findNavController().navigate(R.id.fragmentB,
                        FragmentBArgs(selectedCar).toBundle(),
                        NavigationConfig.defaultNavigationBuilder.build())

            }
        }
    }

}