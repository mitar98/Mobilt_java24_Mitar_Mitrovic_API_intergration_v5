package com.example.weathernavapp.network

data class WeatherNow(val name:String, val main:Main, val wind:Wind, val weather:List<Wx>)
data class Main(val temp:Double, val feels_like:Double, val humidity:Int)
data class Wind(val speed:Double)
data class Wx(val icon:String, val description:String)

data class ForecastResponse(val list:List<ForecastItem>)
data class ForecastItem(val dt:Long, val main:Main, val weather:List<Wx>, val wind:Wind)