package com.example.street_food_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class userdash : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userdash)

        val btn = findViewById<Button>(R.id.btnshow)
        val btn2 = findViewById<Button>(R.id.btnnft)
        val btnfeed = findViewById<Button>(R.id.btnfeed)

        btn.setOnClickListener {
            val intent = Intent(applicationContext,location::class.java)
            startActivity(intent)
        }

        btn2.setOnClickListener {
            val intent = Intent(applicationContext,notify::class.java)
            startActivity(intent)
        }
        btnfeed.setOnClickListener {
            val intent = Intent(applicationContext,showfeedback::class.java)
            startActivity(intent)
        }


    }



        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.item, menu)
        return true

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add-> {
                val intent = Intent(applicationContext,location::class.java)
                startActivity(intent)

            }
            R.id.phistory -> {
                val intent = Intent(applicationContext,notify::class.java)
                startActivity(intent)

            }
            R.id.pahistory-> {

                val intent = Intent(applicationContext,showfeedback::class.java)
                startActivity(intent)
            }




        }
        return true
    }


}