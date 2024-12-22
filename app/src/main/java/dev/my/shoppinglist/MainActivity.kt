package dev.my.shoppinglist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// MainActivity.kt
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Splash Screen Logic
        lifecycleScope.launch {
            showSplashScreen()
            navigateToMainScreen()
        }
    }

    private suspend fun showSplashScreen() {
        setContentView(R.layout.activity_splash)

        val text: TextView = findViewById(R.id.motivation)
        val logo: ImageView = findViewById(R.id.imageView)

        // Animate text and logo
        text.alpha = 0f
        text.animate().alpha(1f).setDuration(1000).start()

        logo.alpha = 0f
        logo.animate().alpha(1f).setDuration(1000).start()

        // Simulate loading time
        delay(2000)
    }

    private fun navigateToMainScreen() {
        setContentView(R.layout.activity_main)

        // Add button logic to navigate to Editing Screen
        val createListButton: Button = findViewById(R.id.createListButton)
        createListButton.setOnClickListener {
            startActivity(Intent(this, EditingActivity::class.java))
        }
    }
}
