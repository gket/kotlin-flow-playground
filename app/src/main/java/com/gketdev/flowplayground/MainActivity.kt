package com.gketdev.flowplayground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.gketdev.flowplayground.playground.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        val button = findViewById<Button>(R.id.button)
        val buttonCold = findViewById<Button>(R.id.buttonCold)
        val buttonMap = findViewById<Button>(R.id.buttonMap)
        val buttonTransform = findViewById<Button>(R.id.buttonTransform)
        val buttonTake = findViewById<Button>(R.id.buttonTake)
        val buttonReduce = findViewById<Button>(R.id.buttonReduce)
        val buttonFilter = findViewById<Button>(R.id.buttonFilter)

        button.setOnClickListener {
            startActivity(Intent(this, SimpleStreamFlow::class.java))
        }
        buttonCold.setOnClickListener {
            startActivity(Intent(this, FlowsAreCold::class.java))
        }
        buttonMap.setOnClickListener {
            startActivity(Intent(this, MapOperator::class.java))
        }
        buttonTransform.setOnClickListener {
            startActivity(Intent(this, TransformOperator::class.java))
        }
        buttonTake.setOnClickListener {
            startActivity(Intent(this, TakeOperator::class.java))
        }
        buttonReduce.setOnClickListener {
            startActivity(Intent(this, ReduceOperator::class.java))
        }
        buttonFilter.setOnClickListener {
            startActivity(Intent(this, FilterOperator::class.java))
        }
    }
}