
package com.raywenderlich.android.rwandroidtutorial.di

import com.raywenderlich.android.rwandroidtutorial.WeatherRepository
import com.raywenderlich.android.rwandroidtutorial.WeatherRepositoryImpl

class DependencyInjectorImpl : DependencyInjector {
  override fun weatherRepository() : WeatherRepository {
    return WeatherRepositoryImpl()
  }
}
