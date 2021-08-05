package com.gketdev.flowplayground.playground

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.gketdev.flowplayground.R
import com.gketdev.flowplayground.data.Food
import com.gketdev.flowplayground.data.Origin
import com.gketdev.flowplayground.utils.FoodGenerator
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class FilterOperator : AppCompatActivity() {

    private var text = ""
    private var textDescription = "Filter and Map"

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
            streamFlow.filter {
                it.origin == Origin.TURKEY
            }.map { it.name }
                .collect {
                    text += it + "\n"
                    textView.text = text
                }
        }
    }

}


