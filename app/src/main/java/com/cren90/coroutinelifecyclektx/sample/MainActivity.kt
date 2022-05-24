package com.cren90.coroutinelifecyclektx.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cren90.coroutinelifecyclektx.sample.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MainActivity : AppCompatActivity() {

    val coroutineFlowFromSomewhere = flow<Int> {
        for (i in 0..100) {
            emit(i)
            delay(500)
        }
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}