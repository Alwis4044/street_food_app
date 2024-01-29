package com.example.street_food_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class vendor_dash : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendor_dash)



        val btnuprofile = findViewById<Button>(R.id.btnuprofile)
        btnuprofile.setOnClickListener {
            val intent = Intent(applicationContext, displayprofile::class.java)
            startActivity(intent)
        }

        val btnadd = findViewById<Button>(R.id.btnproduct)

        btnadd.setOnClickListener {

            val intent = Intent(applicationContext, FoodAdd::class.java)
            startActivity(intent)
        }

        val btnshow = findViewById<Button>(R.id.btnshow)

        btnshow.setOnClickListener {

            val intent = Intent(applicationContext, ShowOurFood::class.java)
            startActivity(intent)
        }

        val btnuproduct = findViewById<Button>(R.id.btnuproduct)

        btnuproduct.setOnClickListener {

            val intent = Intent(applicationContext, Updatefood::class.java)
            startActivity(intent)
        }





    }
}