package com.example.weatherapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentListBinding
import com.example.weatherapp.databinding.FragmentLookupBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class ListFragment : Fragment(R.layout.fragment_list) {
    lateinit var binding: FragmentListBinding
    val fragDetail: DetailFragment by lazy { DetailFragment() }
    val fragLookup: LookupFragment by lazy { LookupFragment() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    fun initUI() {
        binding.vBackArrow.setOnClickListener {

            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_layout, fragLookup,"toLookupFrag")
                disallowAddToBackStack()
                commit()
            }
        }
    }
}