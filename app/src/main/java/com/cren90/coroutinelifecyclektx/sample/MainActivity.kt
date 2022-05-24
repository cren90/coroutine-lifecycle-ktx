package com.cren90.coroutinelifecyclektx.sample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import com.cren90.coroutinelifecyclektx.launchForState
import com.cren90.coroutinelifecyclektx.sample.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val coroutineFlowFromSomewhere = flow<Int> {
        for (i in 0..100) {
            emit(i)
            delay(500)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // The activity in this case is the lifecycle owner. In a fragment it would be
        // viewLifecycleOwner.
        launchForState(Lifecycle.State.STARTED) {
            coroutineFlowFromSomewhere.collect {
                Log.d("Sample", "Flow value = $it")
            }
        }
    }
}