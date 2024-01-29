package com.example.street_food_app

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.database.DatabaseReference

class productdetails : AppCompatActivity() {


    var name: String? = null
    var material: String? = null
    var manifacute: String? = null
    var origin: String? = null
    var weight: String? = null
    var rating: String? = null
    var demi: String? = null
    var price: String? = null

    var ref: DatabaseReference? = null
    var username: String? = null
    var usermobile: String? = null
    var useremail: String? = null
    var useraddress: String? = null
    var url: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productdetails)


        val txtproname = findViewById<TextView>(R.id.txtname)
        val txtmaterial = findViewById<TextView>(R.id.txtmaterial)
        val txtaddress = findViewById<TextView>(R.id.txtmanifacture)

        val txtarea = findViewById<TextView>(R.id.txtorigin)
        val txtwight = findViewById<TextView>(R.id.txtweigth)
        val txtrating = findViewById<TextView>(R.id.txtrating)
        val txtdemi = findViewById<TextView>(R.id.txtdime)


        val image = findViewById<ImageView>(R.id.image1)
        val bundle = intent.extras

        name = bundle?.getString("proname")
        material = bundle?.getString("material")
        manifacute = bundle?.getString("manifacture")
        origin = bundle?.getString("origin")
        weight = bundle?.getString("weight")
        rating = bundle?.getString("rating")
        demi = bundle?.getString("dimension")


        url = bundle?.getString("url")

        Glide.with(this@productdetails).load(url).into(image)

        txtproname.setText("Shop Name:" + name)
        txtmaterial.setText("Address: " + material)
        txtaddress.setText("Number: " + manifacute)
        txtarea.setText("Food: " + origin)
        txtwight.setText("Food: " + weight)
        txtrating.setText("Food: " + rating)
        txtdemi.setText("Food: " + demi)
//        txtprice.setText("Price: " + price)




        val btnorder = findViewById<Button>(R.id.btnorder)
        btnorder.setOnClickListener {
            val intent = Intent(applicationContext,userfeedback::class.java)
            intent.putExtra("name",name)

            startActivity(intent)
        }

        val btntrack = findViewById<Button>(R.id.btntrack)
        btntrack.setOnClickListener {
            try {
                val uri = Uri.parse("https://www.google.co.in/maps/dir/"+""+"/"+ material)

                val intent = Intent(Intent.ACTION_VIEW,uri)
                intent.setPackage("com.google.android.apps.maps")
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)

            }catch (e: ActivityNotFoundException)
            {
                val uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps")
                val intent = Intent(Intent.ACTION_VIEW,uri)
                intent.setPackage("com.google.android.apps.maps")
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }

        }
    }


}