package com.muhammadahmad.notenest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.muhammadahmad.notenest.ui.HomeScreenFragment
import com.muhammadahmad.notenest.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeScreenFragment())
            .commit()
    }
}
