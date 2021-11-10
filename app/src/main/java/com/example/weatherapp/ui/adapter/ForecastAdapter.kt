package com.example.weatherapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.data.model.ForecastResponse
import com.example.weatherapp.databinding.ItemForecastBinding
import com.example.weatherapp.ui.view.ListFragmentDirections
import kotlinx.android.synthetic.main.item_forecast.view.*
import retrofit2.Response
import javax.inject.Inject

class ForecastAdapter @Inject constructor(
) : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    private val items = mutableListOf<Response<ForecastResponse>>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val binding = ItemForecastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ForecastViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val item = items[position]
        Log.d("ForecastAdapter", "onBindViewHolder: $item")
        holder.bind(item)
        val action =
            item.body()?.let {
                ListFragmentDirections.actionListFragmentToDetailFragment(
                    it
                )
            }
        holder.itemView.setOnClickListener {
            action?.let { forecastResponse -> it.findNavController().navigate(forecastResponse) }
//            Toast.makeText(holder.itemView.context, items[position], Toast.LENGTH_SHORT).show()
        }
    }

    class ForecastViewHolder(itemView: ItemForecastBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bind(item: Response<ForecastResponse>) {
            val weather = item.body()?.weather?.get(0)?.description.toString()
            val temp = item.body()?.main?.temp.toString()
            Log.d("ForecastAdapter", "ForecastViewHolder: $weather $temp")

            itemView.tv_weather.text = weather
            itemView.tv_temp.text = "Temp $temp"
        }
    }

    fun addData(items: Response<ForecastResponse>) {
        this.items.apply {
            clear()
            addAll(mutableListOf(items))
            notifyDataSetChanged()
        }
    }
}