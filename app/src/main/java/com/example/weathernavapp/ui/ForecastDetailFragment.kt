package com.example.weathernavapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.weathernavapp.databinding.FragmentForecastDetailBinding
import com.example.weathernavapp.model.ForecastUi
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ForecastDetailFragment : Fragment() {
    private var _b: FragmentForecastDetailBinding? = null
    private val b get() = _b!!

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, s: Bundle?): View {
        _b = FragmentForecastDetailBinding.inflate(i, c, false)
        return b.root
    }

    override fun onViewCreated(v: View, s: Bundle?) {
        val ui: ForecastUi = requireArguments().getParcelable("item")!!
        val fmt = SimpleDateFormat("EEE dd MMM HH:mm", Locale.getDefault())

        b.tvWhen.text = fmt.format(Date(ui.dt * 1000))
        b.tvSummary.text = ui.desc
        b.tvNumbers.text = "Temp ${ui.temp}°, Feels ${ui.feels}°, Wind ${ui.wind} m/s, RH ${ui.humidity}%"
        Glide.with(b.imgIcon).load("https://openweathermap.org/img/wn/${ui.icon}@2x.png").into(b.imgIcon)
    }

    override fun onDestroyView() { _b = null; super.onDestroyView() }
}