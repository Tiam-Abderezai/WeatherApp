package com.example.weatherapp.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.BuildConfig
import com.example.weatherapp.R
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.databinding.FragmentListBinding
import com.example.weatherapp.ui.adapter.ClickListener
import com.example.weatherapp.ui.adapter.WeatherAdapter
import com.example.weatherapp.ui.viewmodel.WeatherViewModel
import com.example.weatherapp.utils.Status
import kotlinx.android.synthetic.main.fragment_list.*
import retrofit2.Response
import javax.inject.Inject


class ListFragment : Fragment(R.layout.fragment_list), ClickListener {
    private lateinit var cityName : String
    lateinit var binding: FragmentListBinding
    private val weatherViewModel: WeatherViewModel by activityViewModels()
    private val weatherAdapter by lazy { WeatherAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        initUI()
        initAPI()
        return binding.root
    }

    fun initUI() {
        binding.apply {
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = weatherAdapter
                addItemDecoration(
                    DividerItemDecoration(
                        context,
                        (layoutManager as LinearLayoutManager).orientation
                    )
                )

            }
        }

    }

    private fun initAPI() {
        weatherViewModel.fetchWeatherData(cityName, BuildConfig.API_KEY)
            .observe(viewLifecycleOwner) {
                when (it.status) {
                    Status.SUCCESS -> {
                        Log.i("ListFragment", "Success: ${it}")
//                    binding.progressBar.visibility = View.INVISIBLE
                        it.data?.let { usersData -> renderList(usersData) }
//                        binding.recyclerView.visibility = View.INVISIBLE
                    }
                    Status.LOADING -> {
                        Log.i("ListFragment", "Loading: ${it.message}")
//                    binding.progressBar.visibility = View.INVISIBLE
//                        binding.recyclerView.visibility = View.INVISIBLE
                    }
                    Status.ERROR -> {
                        //Handle Error
                        Log.d("ListFragment", "Error: ${it.message}")
//                    binding.progressBar.visibility = View.INVISIBLE
                        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
    }

    private fun renderList(items: Response<WeatherResponse>) {
        weatherAdapter.apply {
            addData(items)
        }
    }

    override fun itemClicked(weather: WeatherResponse) {
        val action = ListFragmentDirections.actionListFragmentToDetailFragment(weather, cityName)
        findNavController().navigate(action)
    }
}