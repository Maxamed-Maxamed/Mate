package com.example.hydrate_mate.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.hydrate_mate.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    

    // Function to open SecondActivity when the button is clicked
    fun openSecondActivity(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}
