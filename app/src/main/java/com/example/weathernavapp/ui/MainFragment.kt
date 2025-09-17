package com.example.weathernavapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.weathernavapp.R
import com.example.weathernavapp.databinding.FragmentMainBinding
import com.example.weathernavapp.vm.WeatherVm

class MainFragment : Fragment() {
    private var _b: FragmentMainBinding? = null
    private val b get() = _b!!
    private val vm: WeatherVm by activityViewModels()

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, s: Bundle?): View {
        _b = FragmentMainBinding.inflate(i, c, false)
        return b.root
    }

    override fun onViewCreated(v: View, s: Bundle?) {
        b.btnChangeCity.setOnClickListener {
            findNavController().navigate(R.id.action_main_to_citySearch)
        }
        b.btnOpenForecast.setOnClickListener {
            findNavController().navigate(R.id.action_main_to_forecastList)
        }

        vm.city.observe(viewLifecycleOwner) { b.tvCity.text = it }
        vm.now.observe(viewLifecycleOwner) { now ->
            now ?: return@observe
            b.tvTemp.text = "${now.main.temp.toInt()}°"
            b.tvMeta.text = "Feels ${now.main.feels_like.toInt()}°, Wind ${now.wind.speed} m/s, RH ${now.main.humidity}%"
            val icon = now.weather.firstOrNull()?.icon ?: "01d"
            Glide.with(b.imgIcon).load("https://openweathermap.org/img/wn/${icon}@2x.png").into(b.imgIcon)
        }

        if (vm.now.value == null) vm.refresh()
    }

    override fun onDestroyView() { _b = null; super.onDestroyView() }
}