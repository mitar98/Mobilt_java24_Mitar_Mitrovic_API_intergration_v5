package com.example.weathernavapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weathernavapp.R
import com.example.weathernavapp.model.ForecastUi
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ForecastAdapter(
    private val onClick: (ForecastUi) -> Unit
) : RecyclerView.Adapter<ForecastAdapter.VH>() {

    private val items = mutableListOf<ForecastUi>()
    private val fmt = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())

    fun submit(list: List<ForecastUi>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    inner class VH(v: View) : RecyclerView.ViewHolder(v) {
        val img: ImageView = v.findViewById(R.id.imgIcon)
        val tvTime: TextView = v.findViewById(R.id.tvTime)
        val tvDesc: TextView = v.findViewById(R.id.tvDesc)
        val tvTemp: TextView = v.findViewById(R.id.tvTemp)
        init { v.setOnClickListener { onClick(items[bindingAdapterPosition]) } }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_forecast, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(h: VH, pos: Int) {
        val it = items[pos]
        h.tvTime.text = fmt.format(Date(it.dt * 1000))
        h.tvDesc.text = it.desc
        h.tvTemp.text = "${it.temp.toInt()}°"
        Glide.with(h.img).load("https://openweathermap.org/img/wn/${it.icon}@2x.png").into(h.img)
    }

    override fun getItemCount() = items.size
}