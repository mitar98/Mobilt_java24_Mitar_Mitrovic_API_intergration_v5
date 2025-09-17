package com.example.weathernavapp.vm

import android.app.Application
import androidx.lifecycle.*
import com.example.weathernavapp.network.Api
import com.example.weathernavapp.network.ForecastItem
import com.example.weathernavapp.network.WeatherNow
import kotlinx.coroutines.launch

class WeatherVm(app: Application) : AndroidViewModel(app) {
    private val api = Api.service

    private val _city = MutableLiveData("Malmö")
    val city: LiveData<String> = _city

    private val _now = MutableLiveData<WeatherNow?>()
    val now: LiveData<WeatherNow?> = _now

    private val _forecast = MutableLiveData<List<ForecastItem>>(emptyList())
    val forecast: LiveData<List<ForecastItem>> = _forecast

    fun setCity(c: String) {
        _city.value = c
        refresh()
    }

    fun refresh() = viewModelScope.launch {
        val c = _city.value ?: "Malmö"
        _now.value = api.current(c)
        _forecast.value = api.forecast(c).list
    }
}