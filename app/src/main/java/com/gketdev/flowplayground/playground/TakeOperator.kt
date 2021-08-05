package com.gketdev.flowplayground.playground

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.gketdev.flowplayground.R
import com.gketdev.flowplayground.data.Food
import com.gketdev.flowplayground.utils.FoodGenerator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class TakeOperator : AppCompatActivity() {

    private var text = ""
    private var textDescription = "Take 3!"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stream_flow)
        val textView = findViewById<TextView>(R.id.textView)
        val textViewDescription = findViewById<TextView>(R.id.textViewDescription)

        textViewDescription.text = textDescription

        val list = FoodGenerator.generateFoods()

        val streamFlow: Flow<Food> = flow {
            try {
                repeat(list.size) {
                    emit(list[it])
                    delay(100)
                }
            } finally {

                    textView.text = "$text \n Done? OMG! You are crazy"

            }
        }

        lifecycleScope.launchWhenCreated {
            streamFlow.take(3).collect {
                text += it.name + "\n"
                textView.text = text
            }
        }

    }
}