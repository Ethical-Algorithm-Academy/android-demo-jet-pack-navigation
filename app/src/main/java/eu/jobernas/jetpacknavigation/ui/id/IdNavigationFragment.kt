package eu.jobernas.jetpacknavigation.ui.id

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import eu.jobernas.jetpacknavigation.R
import eu.jobernas.jetpacknavigation.databinding.FragmentNavigationIdBinding
import eu.jobernas.jetpacknavigation.helpers.NavigationConfig
import eu.jobernas.jetpacknavigation.models.Moto
import eu.jobernas.jetpacknavigation.ui.details.MotoDetailsFragmentArgs

class IdNavigationFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = IdNavigationFragment()
    }

    private var binding: FragmentNavigationIdBinding? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentNavigationIdBinding.inflate(inflater, container, false)
        binding?.apply {
            idActionButton.setOnClickListener(this@IdNavigationFragment)
        }
        return binding?.root
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.id_action_button -> {
                // Calling Fragment By ID with Args Auto Generated
                val selectedMoto = Moto("32", "DT", Color.WHITE, "Yamaha", false)
                val bundle = MotoDetailsFragmentArgs(selectedMoto).toBundle()
                findNavController().navigate(R.id.moto_details_screen,
                                             bundle,
                                             NavigationConfig.defaultNavigationBuilder.build())
            }
        }
    }

}