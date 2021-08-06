package com.gketdev.flowplayground.playground

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.gketdev.flowplayground.R
import com.gketdev.flowplayground.data.Food
import com.gketdev.flowplayground.utils.FoodGenerator
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class ZipOperator : AppCompatActivity() {

    private var text = ""
    private var textDescription = "We can work with 2 different datas"

    @FlowPreview
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stream_flow)
        val textView = findViewById<TextView>(R.id.textView)
        val textViewDescription = findViewById<TextView>(R.id.textViewDescription)

        textViewDescription.text = textDescription

        val list = FoodGenerator.generateFoods()
        val nums = (1..list.size).asFlow()


        val streamFlow: Flow<Food> = flow {
            repeat(list.size) {
                emit(list[it])
                delay(100)
            }
        }

        lifecycleScope.launchWhenCreated {
            streamFlow.zip(nums) { list, nums ->
                "${list.origin}$nums" + "\n"
            }.collect {
                text += it
                textView.text = text
            }
        }


    }
}