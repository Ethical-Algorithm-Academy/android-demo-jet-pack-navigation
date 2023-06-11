package eu.jobernas.jetpacknavigation.ui.main.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import eu.jobernas.jetpacknavigation.R
import eu.jobernas.jetpacknavigation.databinding.FragmentNotificationBinding
import eu.jobernas.jetpacknavigation.helpers.NavigationConfig
import eu.jobernas.jetpacknavigation.models.Car
import eu.jobernas.jetpacknavigation.ui.main.b.FragmentBArgs

class FragmentNotifications : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = FragmentNotifications()
    }

    private var binding: FragmentNotificationBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding?.actionA?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.actionA -> {
                // New Way
                val selectedCar = Car("this is a car from Notifications View", 1010)
//                val action = FragmentADirections.actionFragmentAToFragmentB(selectedCar)
//                v.findNavController().navigate(action)

                // Compatible Old Way
                v.findNavController().navigate(R.id.fragmentA,
                        FragmentBArgs(selectedCar).toBundle(),
                        NavigationConfig.defaultNavigationBuilder.build())

            }
        }
    }

}