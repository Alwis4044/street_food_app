package com.example.street_food_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class userfeedback : AppCompatActivity() {

    var edname: EditText?=null
    var edprofile: EditText?=null
    var edcriteria: EditText?=null
    var edtime: EditText?=null
    var edhrname: EditText?=null
    var edcontact: EditText?=null
    var edaddress: EditText?=null
    var name:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userfeedback)

        val bundle = intent.extras

        name = bundle?.getString("name")

        Toast.makeText(applicationContext,name.toString(),Toast.LENGTH_LONG).show()
        edname = findViewById<EditText>(R.id.edtype)
        edprofile = findViewById<EditText>(R.id.edname)
        edcriteria = findViewById<EditText>(R.id.eddes)


    }

    fun UploadData(view: View?) {
        val category = edname!!.text.toString()
        val uname = edprofile!!.text.toString()
        val description = edcriteria!!.text.toString()



        val data = FirebaseDatabase.getInstance().reference.child("Feedback")
        val service = feed(category,uname,description,name)


        data.push().setValue(service)

        Toast.makeText(applicationContext,"Uploaded", Toast.LENGTH_LONG).show()



    }

}