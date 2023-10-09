package eu.jobernas.jetpacknavigation.ui.deeplink

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import eu.jobernas.jetpacknavigation.R
import eu.jobernas.jetpacknavigation.databinding.FragmentDeeplinkBinding
import eu.jobernas.jetpacknavigation.helpers.NavigationConfig

class DeeplinkFragment: Fragment(),
    View.OnClickListener {

    companion object {
        fun newInstance() = DeeplinkFragment()
    }

    private var binding: FragmentDeeplinkBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentDeeplinkBinding.inflate(inflater, container, false)
        binding?.apply {
            deeplinkActionButton.setOnClickListener(this@DeeplinkFragment)
        }
        return binding?.root
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.deeplink_action_button -> {
                // This is an Example of Calling a Fragment through Deeplink Uri
                val deeplinkUri = Uri.parse("https://www.ealgorithm.net/moto/32")
                findNavController()
                    .navigate(deeplinkUri, NavigationConfig.defaultNavigationBuilder.build())
            }
        }
    }

}