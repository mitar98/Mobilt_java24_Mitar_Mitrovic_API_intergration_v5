package com.example.weathernavapp.ui

import com.example.weathernavapp.model.ForecastUi
import com.example.weathernavapp.network.ForecastItem

fun ForecastItem.toUi() = ForecastUi(
    dt = dt,
    temp = main.temp,
    feels = main.feels_like,
    wind = wind.speed,
    humidity = main.humidity,
    icon = weather.firstOrNull()?.icon ?: "01d",
    desc = weather.firstOrNull()?.description ?: ""
)