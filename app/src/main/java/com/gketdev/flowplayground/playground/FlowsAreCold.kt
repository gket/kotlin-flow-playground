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

    private var text = ""
    private var textDescription = " Flows are cold\n" +
            "    Hot streams push values even when there is no one consuming them.\n" +
            "    However, cold streams, start pushing values only when you start collecting!"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stream_flow)
        val textView = findViewById<TextView>(R.id.textView)
        val textViewDescription = findViewById<TextView>(R.id.textViewDescription)

        val list = FoodGenerator.generateFoods()

        textViewDescription.text = textDescription

        val streamFlow: Flow<Food> = flow {
            repeat(list.size) {
                emit(list[it])
                delay(2000)
            }
        }

        lifecycleScope.launchWhenCreated {
            //10 seconds after streamed and lets watch
            delay(10000)
            textViewDescription.text = "Cool"
            streamFlow.collect {
                text += it.name + "\n"
                textView.text = text
            }
        }


    }

}