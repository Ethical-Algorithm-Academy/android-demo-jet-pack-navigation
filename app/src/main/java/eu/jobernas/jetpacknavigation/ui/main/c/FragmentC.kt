package eu.jobernas.jetpacknavigation.ui.main.c

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import eu.jobernas.jetpacknavigation.databinding.FragmentCBinding

class FragmentC : Fragment() {

    companion object {
    }

    private var binding: FragmentCBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentCBinding.inflate(inflater, container, false)
        return binding?.root
    }
}