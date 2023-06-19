package eu.jobernas.jetpacknavigation.ui.menu

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import eu.jobernas.jetpacknavigation.R
import eu.jobernas.jetpacknavigation.databinding.FragmentMenuBinding
import eu.jobernas.jetpacknavigation.helpers.NavigationConfig
import eu.jobernas.jetpacknavigation.models.Vehicle
import eu.jobernas.jetpacknavigation.ui.main.CarDetailsFragment

class MenuFragment: Fragment(),
    View.OnClickListener {

    companion object {
        fun newInstance() = MenuFragment()
    }

    private var binding: FragmentMenuBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        binding?.apply {
            menuActionButton.setOnClickListener(this@MenuFragment)
        }
        return binding?.root
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.menu_action_button -> {
                // This is an Example of Calling a Fragment by ID instead of Action;
                val selectedVehicle = Vehicle("Auris", Color.RED, "Toyota")
                val bundle = CarDetailsFragment.getBundle(selectedVehicle)
                findNavController()
                    .navigate(R.id.car_details_screen, bundle, NavigationConfig.defaultNavigationBuilder.build())
            }
        }
    }

}