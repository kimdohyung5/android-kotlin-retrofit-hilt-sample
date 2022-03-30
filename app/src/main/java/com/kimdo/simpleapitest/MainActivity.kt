package com.kimdo.simpleapitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: QuestionViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addObservers()
    }

    private fun addObservers() {
        viewModel.data.observe(this) { data ->
            Log.d(TAG, "addObservers: ${data.loading} ${data.data} ${data.e}")

        }
    }

    companion object {
        val TAG = "MainActivity"
    }
}