package eu.jobernas.jetpacknavigation.ui.notifications

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import eu.jobernas.jetpacknavigation.R
import eu.jobernas.jetpacknavigation.databinding.FragmentNotificationBinding
import eu.jobernas.jetpacknavigation.helpers.NavigationConfig
import eu.jobernas.jetpacknavigation.models.Vehicle
import eu.jobernas.jetpacknavigation.ui.main.VehicleDetailsFragmentArgs

class NotificationsFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = NotificationsFragment()
    }

    private var binding: FragmentNotificationBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentNotificationBinding.inflate(inflater, container, false)
        binding?.apply {
            notificationsActionButton.setOnClickListener(this@NotificationsFragment)

        }
        return binding?.root
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.notifications_action_button -> {
                // New Way
                val selectedVehicle = Vehicle("this is a car from Notifications View", Color.BLUE, "test")
                // Compatible Old Way
//                val directions = NotificationsFragmentDirections.actionNotificationsScreenToVehicleDetailsScreen(selectedVehicle)
//                findNavController().navigate(directions)
                findNavController().navigate(R.id.popup)
            }
        }
    }

}