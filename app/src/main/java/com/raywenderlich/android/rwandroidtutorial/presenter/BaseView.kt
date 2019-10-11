package com.raywenderlich.android.rwandroidtutorial.presenter


interface BaseView<T> {
    //the view uses this presenter
    fun setPresenter(presenter : T)
}