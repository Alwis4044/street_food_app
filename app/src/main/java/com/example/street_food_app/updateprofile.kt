package com.example.street_food_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class updateprofile : AppCompatActivity() {

    var name: String? = null
    var address: String? = null
    var number: String? = null
    var username:String?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updateprofile)


        val sh = getSharedPreferences("MySharedPref", MODE_PRIVATE)

        username = sh.getString("id", "")
        Toast.makeText(applicationContext, username.toString(), Toast.LENGTH_LONG).show()



        val edname = findViewById<EditText>(R.id.edname)
        val edmono = findViewById<EditText>(R.id.edmono)
        val edaddress = findViewById<EditText>(R.id.edaddress)


        val btnupdate = findViewById<Button>(R.id.update)

        btnupdate.setOnClickListener {
            name = edname.text.toString()
            number = edmono.text.toString()
            address = edaddress.text.toString()


            val databaseReference = FirebaseDatabase.getInstance().getReference("Vendor").child(username!!)
            databaseReference.child("name").setValue(name)
            databaseReference.child("number").setValue(number)
            databaseReference.child("address").setValue(address)
            Toast.makeText(applicationContext,"Updated",Toast.LENGTH_LONG).show()



        }

    }
}