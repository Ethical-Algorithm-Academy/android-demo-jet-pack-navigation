package com.beatstars.testingjetpacknavigation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.beatstars.testingjetpacknavigation.R
import com.beatstars.testingjetpacknavigation.helpers.NavigationConfig
import com.beatstars.testingjetpacknavigation.models.Car
import kotlinx.android.synthetic.main.fragment_notification.*

class FragmentNotifications : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = FragmentNotifications()
    }

    private lateinit var viewModelA: ViewModelA

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        actionA.setOnClickListener(this)
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