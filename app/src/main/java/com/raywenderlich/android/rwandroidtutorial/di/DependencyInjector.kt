package com.raywenderlich.android.rwandroidtutorial.di

import com.raywenderlich.android.rwandroidtutorial.WeatherRepository

interface DependencyInjector {
  fun weatherRepository() : WeatherRepository
}
