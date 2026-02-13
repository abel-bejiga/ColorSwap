package com.example.colorswap

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var view: View
    private lateinit var button: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.view)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val colorArray = arrayOf(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA, Color.BLACK, Color.WHITE, Color.GRAY, Color.DKGRAY, Color.LTGRAY, Color.TRANSPARENT, Color.LTGRAY, Color.DKGRAY)
        var lastIndex = -1
        var rotationVal = 0f

        view  = findViewById(R.id.view)
        button = findViewById(R.id.floatingBtn)

        button.setOnClickListener {
            var newIndex: Int
            do {
                newIndex = colorArray.indices.random()
            } while (newIndex == lastIndex)

            lastIndex = newIndex
            view.setBackgroundColor(colorArray[newIndex])
            rotationVal += 65f
            button.animate().rotation(rotationVal).setDuration(100).start()
        }
    }
}