package com.example.weathernavapp.network

import com.example.weathernavapp.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApi {
    @GET("data/2.5/weather")
    suspend fun current(@Query("q") city:String,
                        @Query("units") units:String = "metric",
                        @Query("appid") key:String = BuildConfig.OWM_KEY): WeatherNow

    @GET("data/2.5/forecast")
    suspend fun forecast(@Query("q") city:String,
                         @Query("units") units:String = "metric",
                         @Query("appid") key:String = BuildConfig.OWM_KEY): ForecastResponse
}