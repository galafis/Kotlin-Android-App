/**
 * Kotlin Android App
 * @author Gabriel Demetrios Lafis
 */

package com.galafis.kotlinapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    
    private lateinit var counterText: TextView
    private lateinit var nameInput: EditText
    private lateinit var greetingText: TextView
    private lateinit var incrementButton: Button
    private lateinit var decrementButton: Button
    private lateinit var resetButton: Button
    private lateinit var greetButton: Button
    
    private var counter = 0
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        initializeViews()
        setupClickListeners()
        updateCounterDisplay()
        
        // Set author info
        title = "Kotlin App by Gabriel Lafis"
    }
    
    private fun initializeViews() {
        counterText = findViewById(R.id.counterText)
        nameInput = findViewById(R.id.nameInput)
        greetingText = findViewById(R.id.greetingText)
        incrementButton = findViewById(R.id.incrementButton)
        decrementButton = findViewById(R.id.decrementButton)
        resetButton = findViewById(R.id.resetButton)
        greetButton = findViewById(R.id.greetButton)
    }
    
    private fun setupClickListeners() {
        incrementButton.setOnClickListener {
            counter++
            updateCounterDisplay()
        }
        
        decrementButton.setOnClickListener {
            counter--
            updateCounterDisplay()
        }
        
        resetButton.setOnClickListener {
            counter = 0
            updateCounterDisplay()
        }
        
        greetButton.setOnClickListener {
            val name = nameInput.text.toString().trim()
            if (name.isNotEmpty()) {
                greetingText.text = "Hello, $name! 👋\nWelcome to my Kotlin app!"
                greetingText.visibility = TextView.VISIBLE
            } else {
                greetingText.visibility = TextView.GONE
            }
        }
    }
    
    private fun updateCounterDisplay() {
        counterText.text = "Counter: $counter"
    }
}

// Data classes for demonstration
data class User(
    val id: Int,
    val name: String,
    val email: String
)

data class AppInfo(
    val name: String = "Kotlin Android App",
    val version: String = "1.0.0",
    val author: String = "Gabriel Demetrios Lafis"
)

// Extension functions
fun String.isValidEmail(): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun Int.toFormattedString(): String {
    return String.format("%,d", this)
}
