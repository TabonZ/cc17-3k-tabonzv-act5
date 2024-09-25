package com.example.artapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val images = arrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5
    )

    private val titles = arrayOf(
        "Mona Lisa (1503 - 1519",
        "Las Meninas (1656)",
        "The School of Athens (1509 - 1511)",
        "The Tower of Babel (c.1563)",
        "The Night Watch (1642)"
    )

    private val descriptions = arrayOf(
        "A masterpiece capturing an enigmatic smile.",
        "An insightful portrayal of royal life in Spain.",
        "Celebrating the great minds of the Renaissance.",
        "A symbol of human ambition and its limits.",
        "A dramatic depiction of a militia company."
    )

    private val authors = arrayOf(
        "Leonardo da Vinci",
        "Diego Velázquez",
        "Raphael",
        "Pieter Bruegel the Elder",
        "Rembrandt van Rijn"
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView: ImageView = findViewById(R.id.imageView)
        val titleText: TextView = findViewById(R.id.titleText)
        val descriptionText: TextView = findViewById(R.id.descriptionText)
        val authorText: TextView = findViewById(R.id.authorText)
        val previousButton: Button = findViewById(R.id.previous_button)
        val nextButton: Button = findViewById(R.id.next_button)

        updateUI(imageView, titleText, descriptionText, authorText)

        previousButton.setOnClickListener {
            currentIndex = if (currentIndex > 0) currentIndex - 1 else images.size - 1
            updateUI(imageView, titleText, descriptionText, authorText)
        }

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % images.size
            updateUI(imageView, titleText, descriptionText, authorText)
        }
    }

    private fun updateUI(imageView: ImageView, titleText: TextView, descriptionText: TextView, authorText: TextView) {
        imageView.setImageResource(images[currentIndex])
        titleText.text = titles[currentIndex]
        descriptionText.text = descriptions[currentIndex]
        authorText.text = authors[currentIndex]
    }
}
