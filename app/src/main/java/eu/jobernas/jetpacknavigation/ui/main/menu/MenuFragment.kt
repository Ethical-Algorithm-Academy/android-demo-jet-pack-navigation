package eu.jobernas.jetpacknavigation.ui.main.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import eu.jobernas.jetpacknavigation.databinding.FragmentMenuBinding

class MenuFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = MenuFragment()
    }

    private var binding: FragmentMenuBinding? = null
    private lateinit var menuViewModel: MenuViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onClick(v: View?) {
//        when (v?.id) {
//            R.id.actionB -> {
//                // New Way
//                val selectedCar = Car("this is a test car", 1000)
//                val action = FragmentADirections.actionFragmentAToFragmentB(selectedCar)
//                v.findNavController().navigate(action)
//
//                // Old Way
////                v.findNavController().navigate(R.id.action_fragmentA_to_fragmentB, FragmentB.getBundle(selectedCar))
//
//            }
//        }
    }

}