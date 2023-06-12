package eu.jobernas.jetpacknavigation.ui.main.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import eu.jobernas.jetpacknavigation.R
import eu.jobernas.jetpacknavigation.databinding.FragmentMenuBinding
import eu.jobernas.jetpacknavigation.models.Car
import eu.jobernas.jetpacknavigation.ui.main.c.FragmentC

class MenuFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = MenuFragment()
    }

    private var binding: FragmentMenuBinding? = null
    private lateinit var menuViewModel: MenuViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        binding?.actionC?.setOnClickListener(this)
        return binding?.root
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.actionC -> {
                // New Way
                val selectedCar = Car("this is a test car", 1000)
                findNavController().navigate(R.id.fragmentC, FragmentC.getBundle(selectedCar))

                // Old Way
//                v.findNavController().navigate(R.id.action_fragmentA_to_fragmentB, FragmentB.getBundle(selectedCar))

            }
        }
    }

}