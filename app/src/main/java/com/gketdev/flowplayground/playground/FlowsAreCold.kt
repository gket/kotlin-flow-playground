package com.gketdev.flowplayground.playground

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.gketdev.flowplayground.R
import com.gketdev.flowplayground.data.Food
import com.gketdev.flowplayground.utils.FoodGenerator
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

class FlowsAreCold : AppCompatActivity() {

    /*
    Flows are cold
    Hot streams push values even when there is no one consuming them.
    However, cold streams, start pushing values only when you start collecting!
     */

    private var text = ""

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stream_flow)
        val textView = findViewById<TextView>(R.id.textView)

        val list = FoodGenerator.generateFoods()

        val streamFlow: Flow<Food> = flow {
            repeat(list.size) {
                emit(list[it])
                delay(2000)
            }
        }

        lifecycleScope.launchWhenCreated {
            //10 seconds after streamed and lets watch
            delay(10000)
            streamFlow.collect {
                text += it.name + "\n"
                textView.text = text
            }
        }


    }

}