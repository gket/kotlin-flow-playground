package com.gketdev.flowplayground.playground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.gketdev.flowplayground.utils.FoodGenerator
import kotlinx.coroutines.launch

class SimpleCoroutine : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //One-shot call
        lifecycleScope.launch {
            FoodGenerator.generateFoods()
        }
    }

}