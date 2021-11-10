package com.example.weatherapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentMainBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    fun initUI() {
        binding.apply {
            btnLookup.setOnClickListener {
                if (etCity.text.toString().isNotEmpty()) {
                    val action =
                        MainFragmentDirections.actionMainFragmentToListFragment(etCity.text.toString())
                    findNavController().navigate(action)
                } else {
                    Toast.makeText(context, "City cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }


}