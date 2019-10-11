
package com.raywenderlich.android.rwandroidtutorial

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import com.raywenderlich.android.rwandroidtutorial.di.DependencyInjectorImpl
import com.raywenderlich.android.rwandroidtutorial.presenter.MainContract
import com.raywenderlich.android.rwandroidtutorial.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {
  private lateinit var imageView: ImageView
  private lateinit var button: Button
  private lateinit var presenter: MainContract.Presenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)


    imageView = findViewById(R.id.imageView)
    button = findViewById(R.id.button)

    setPresenter(MainPresenter(this, DependencyInjectorImpl()))
    presenter.onViewCreated()//calls load weather method
    button.setOnClickListener { presenter.onLoadWeatherTapped()
      //calls load weather method
    }
  }

  override fun setPresenter(presenter: MainContract.Presenter) {
    this.presenter = presenter
  }

  override fun displayWeatherState(weatherState: WeatherState) {
    val drawable = resources.getDrawable(weatherDrawableResId(weatherState), applicationContext.theme)
    this.imageView.setImageDrawable(drawable)
  }

  private fun weatherDrawableResId(weatherState: WeatherState): Int {
    return when (weatherState) {
      WeatherState.SUN -> R.drawable.ic_sun
      WeatherState.RAIN -> R.drawable.ic_umbrella
    }
  }

  override fun onDestroy() {
    presenter.onDestroy()
    super.onDestroy()
  }
}



