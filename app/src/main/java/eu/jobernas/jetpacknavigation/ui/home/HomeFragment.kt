package eu.jobernas.jetpacknavigation.ui.home

import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import eu.jobernas.jetpacknavigation.R
import eu.jobernas.jetpacknavigation.databinding.FragmentHomeBinding
import eu.jobernas.jetpacknavigation.helpers.NavigationConfig
import eu.jobernas.jetpacknavigation.models.Moto
import eu.jobernas.jetpacknavigation.models.Vehicle
import eu.jobernas.jetpacknavigation.ui.main.MotoDetailsFragmentArgs

class HomeFragment : Fragment(),
    View.OnClickListener {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding?.apply {
            homeActionButton.setOnClickListener(this@HomeFragment)
        }
        return binding?.root
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.home_action_button -> {
                // Calling Fragment By ID with Args Auto Generated
                val selectedMoto = Moto("32", "DT", Color.WHITE, "Yamaha", false)
//                val bundle = MotoDetailsFragmentArgs(selectedMoto).toBundle()
                findNavController()
                    .navigate(Uri.parse("https://www.google.pt/32"))
//                    .navigate(R.id.moto_details_screen,
//                        bundle, NavigationConfig.defaultNavigationBuilder.build())

            }
        }
    }

}