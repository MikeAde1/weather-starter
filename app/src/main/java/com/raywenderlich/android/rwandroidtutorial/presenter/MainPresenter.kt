package com.raywenderlich.android.rwandroidtutorial.presenter

import com.raywenderlich.android.rwandroidtutorial.Weather
import com.raywenderlich.android.rwandroidtutorial.WeatherRepository
import com.raywenderlich.android.rwandroidtutorial.WeatherState
import com.raywenderlich.android.rwandroidtutorial.di.DependencyInjector

class MainPresenter(
        view: MainContract.View,
        dependencyInjector: DependencyInjector) : MainContract.Presenter {
    //injects an instance of weather repository
    private val weatherRepository: WeatherRepository
            = dependencyInjector.weatherRepository()

    //instance of the presenter view
    private var view: MainContract.View? = view

    private fun loadWeather() {
        val weather = weatherRepository.loadWeather()
        val weatherState = weatherStateForWeather(weather)

        // Make sure to call the displayWeatherState on the view
        view?.displayWeatherState(weatherState)
    }

    private fun weatherStateForWeather(weather: Weather) : WeatherState {
        if (weather.rain!!.amount!! > 0) {
            return WeatherState.RAIN
        }
        return WeatherState.SUN
    }

    override fun onDestroy() {
        this.view = null
    }

    override fun onViewCreated() {
        loadWeather()
    }
    override fun onLoadWeatherTapped() {
        loadWeather()
    }

}

