package com.gketdev.flowplayground.playground

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.gketdev.flowplayground.R
import com.gketdev.flowplayground.data.Food
import com.gketdev.flowplayground.utils.FoodGenerator
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class MapOperator : AppCompatActivity() {
    /*
 Flows are cold
 Hot streams push values even when there is no one consuming them.
 However, cold streams, start pushing values only when you start collecting!
  */

    private var text = ""
    private var textDescription = "I can play with datas because I am Flow!"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stream_flow)
        val textView = findViewById<TextView>(R.id.textView)
        val textViewDescription = findViewById<TextView>(R.id.textViewDescription)

        textViewDescription.text = textDescription

        val list = FoodGenerator.generateFoods()

        val streamFlow: Flow<Food> = flow {
            repeat(list.size) {
                emit(list[it])
                delay(100)
            }
        }

        lifecycleScope.launchWhenCreated {
            streamFlow.map {
                it.price
            }.collect {
                text += it.toString() + "\n"
                textView.text = text
            }
        }


    }
}