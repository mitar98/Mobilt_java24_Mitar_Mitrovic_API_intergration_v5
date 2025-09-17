package com.example.weathernavapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.weathernavapp.R
import com.example.weathernavapp.databinding.FragmentCitySearchBinding
import com.example.weathernavapp.vm.WeatherVm

class CitySearchFragment : Fragment() {
    private var _b: FragmentCitySearchBinding? = null
    private val b get() = _b!!
    private val vm: WeatherVm by activityViewModels()

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, s: Bundle?): View {
        _b = FragmentCitySearchBinding.inflate(i, c, false)
        return b.root
    }

    override fun onViewCreated(v: View, s: Bundle?) {
        b.btnSaveCity.setOnClickListener {
            val city = b.etCity.text.toString().ifBlank { "Malmö" }
            vm.setCity(city)
            findNavController().navigate(R.id.action_citySearch_to_main_popInclusive)
        }
    }

    override fun onDestroyView() { _b = null; super.onDestroyView() }
}