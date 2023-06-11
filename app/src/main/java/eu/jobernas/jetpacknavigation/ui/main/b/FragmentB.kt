package eu.jobernas.jetpacknavigation.ui.main.b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import eu.jobernas.jetpacknavigation.R
import eu.jobernas.jetpacknavigation.databinding.FragmentBBinding
import eu.jobernas.jetpacknavigation.helpers.NavigationConfig
import eu.jobernas.jetpacknavigation.models.Car
import eu.jobernas.jetpacknavigation.ui.main.c.FragmentCArgs

class FragmentB : Fragment(),
        View.OnClickListener {

    companion object {
        private const val KEY_SELECTED_CAR = "SELECTED_CAR_KEY"

        /**
         * Old Way
         */
        fun newInstance(selectedCar: Car) =
            FragmentB().apply {
                arguments = getBundle(selectedCar)
            }

        fun getBundle(selectedCar: Car): Bundle =
            Bundle().apply {
                putParcelable(KEY_SELECTED_CAR, selectedCar)
            }
    }

    val args: FragmentBArgs by navArgs()
    var selectedCar: Car? = null
    private var binding: FragmentBBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentBBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // Old Way compatibility
//        messageB.text = arguments?.getParcelable<Car>(KEY_SELECTED_CAR)?.title

        // New Way
        selectedCar = args.selectedCar
        binding?.apply {
            messageB.text = "${selectedCar?.title} + Number:${selectedCar?.number}"
            actionC.setOnClickListener(this@FragmentB)
        }
    }

    /**
     * View.OnClickListener
     */
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.actionC -> {
                selectedCar?.title = "Changed Name"
                v.findNavController().navigate(
                    R.id.fragmentC,
                        FragmentCArgs(selectedCar).toBundle(),
                        NavigationConfig.defaultNavigationBuilder.build())
            }
        }

    }

}