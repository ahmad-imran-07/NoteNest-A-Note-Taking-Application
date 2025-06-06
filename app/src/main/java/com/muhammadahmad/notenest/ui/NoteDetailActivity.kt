package com.muhammadahmad.notenest.ui

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.muhammadahmad.notenest.R

class NoteDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")

        findViewById<TextView>(R.id.textViewDetailTitle).text = title
        findViewById<TextView>(R.id.textViewDetailDescription).text = description

        val backButton = findViewById<ImageButton>(R.id.buttonback)
        backButton.setOnClickListener {
            finish()
        }
    }
}
