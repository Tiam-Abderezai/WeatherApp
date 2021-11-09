package com.example.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.databinding.ItemWeatherBinding
import kotlinx.android.synthetic.main.item_weather.view.*
import retrofit2.Response
import javax.inject.Inject

class WeatherAdapter @Inject constructor(
) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    private val items = mutableListOf<Response<WeatherResponse>>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding = ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(items[position])

        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.itemView.context, items[position], Toast.LENGTH_SHORT).show()
        }
    }

    class WeatherViewHolder(itemView: ItemWeatherBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bind(item: Response<WeatherResponse>) {
            itemView.tv_weather.text = item.body()?.weather?.get(0)?.description.toString()
            itemView.tv_temp.text = item.body()?.main?.temp.toString()
        }
    }

    fun addData(items: Response<WeatherResponse>) {
        this.items.apply {
            clear()
            addAll(mutableListOf(items))
            notifyDataSetChanged()
        }
    }
}