package com.eyepetizer.android.base

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel

@SuppressLint("StaticFieldLeak")
abstract class BaseViewModel<AT : AppCompatActivity> : ViewModel() {

    lateinit var activity: AT
}