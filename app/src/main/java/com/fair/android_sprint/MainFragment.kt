package com.fair.android_sprint

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.fair.android_sprint.databinding.FragmentMainBinding

class MainFragment: Fragment(R.layout.fragment_main) {

    private var _binding : FragmentMainBinding? = null
    private val viewBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        val possibleDestinations = listOf(
            R.id.action_mainFragment_to_firstFragment,
            R.id.action_mainFragment_to_secondFragment,
            R.id.action_mainFragment_to_thirdFragment)

        viewBinding.apply {
            randPick.setOnClickListener {
                Navigation.findNavController(view).navigate(possibleDestinations.random())
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}