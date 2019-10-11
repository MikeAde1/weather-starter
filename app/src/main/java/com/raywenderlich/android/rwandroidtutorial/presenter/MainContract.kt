package com.raywenderlich.android.rwandroidtutorial.presenter

import com.raywenderlich.android.rwandroidtutorial.BasePresenter
import com.raywenderlich.android.rwandroidtutorial.WeatherState

interface MainContract {
    interface Presenter : BasePresenter {
        fun onViewCreated()
        fun onLoadWeatherTapped()
    }

    interface View : BaseView<Presenter> {
        fun displayWeatherState(weatherState: WeatherState)
    }
}

