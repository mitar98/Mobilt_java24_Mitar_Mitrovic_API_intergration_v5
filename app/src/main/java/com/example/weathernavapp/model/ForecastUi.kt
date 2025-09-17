package com.example.weathernavapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForecastUi(
    val dt: Long,
    val temp: Double,
    val feels: Double,
    val wind: Double,
    val humidity: Int,
    val icon: String,
    val desc: String
) : Parcelable