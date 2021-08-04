package com.gketdev.flowplayground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.gketdev.flowplayground.playground.FlowsAreCold
import com.gketdev.flowplayground.playground.SimpleStreamFlow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val buttonCold = findViewById<Button>(R.id.buttonCold)
        button.setOnClickListener {
            startActivity(Intent(this, SimpleStreamFlow::class.java))
        }
        buttonCold.setOnClickListener {
            startActivity(Intent(this, FlowsAreCold::class.java))
        }
    }
}