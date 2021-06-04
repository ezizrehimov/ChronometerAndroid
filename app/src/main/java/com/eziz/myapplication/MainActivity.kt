package com.eziz.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var stopTime: Long = 0
        btnStart.setOnClickListener {
            kronometer.base = SystemClock.elapsedRealtime() + stopTime
            kronometer.start()
            btnStart.visibility = View.GONE
            btnPause.visibility = View.VISIBLE
            imageView.setImageDrawable(getDrawable(R.drawable.pause))
        }
        btnPause.setOnClickListener {
            stopTime = kronometer.base - SystemClock.elapsedRealtime()
            kronometer.stop()
            btnPause.visibility = View.GONE
            btnStart.visibility = View.VISIBLE
            imageView.setImageDrawable(getDrawable(R.drawable.start))
        }
        btnReset.setOnClickListener {
            kronometer.base = SystemClock.elapsedRealtime()
            kronometer.stop()
            stopTime = 0
            btnPause.visibility = View.GONE
            btnStart.visibility = View.VISIBLE
            imageView.setImageDrawable(getDrawable(R.drawable.start))
        }
    }
}