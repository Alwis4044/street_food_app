package com.example.street_food_app

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*

class displayprofile : AppCompatActivity() {

    private var database: FirebaseDatabase? = null
    private var mDatabase: DatabaseReference? = null
    var sname: String? = null
    var oname: String? = null
    var address: String? = null
    var mobileno: String? = null
    var contact: String? = null
    var udname: String? = null
    var uhname: String? = null
    var uhaddress: String? = null
    var udesi: String? = null
    var ucontact: String? = null
    var username: String? = null

    var sharedpreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_displayprofile)

        val sh = getSharedPreferences("MySharedPref", MODE_PRIVATE)

        username = sh.getString("name", "")
        Toast.makeText(applicationContext, username.toString(), Toast.LENGTH_LONG).show()



        database = FirebaseDatabase.getInstance()
        mDatabase = database!!.getReference("Profile")
        val update = findViewById<Button>(R.id.btnupdate)
        val txtdname = findViewById<TextView>(R.id.txtdname)
        val txthname = findViewById<TextView>(R.id.txthname)
        val txthaddress = findViewById<TextView>(R.id.txtadress)
//        val txtdesi = findViewById<TextView>(R.id.txtdesi)
//        val txtcontact = findViewById<TextView>(R.id.txtcontact)

        update.setOnClickListener(View.OnClickListener {
            val i = Intent(applicationContext, updateprofile::class.java)
            startActivity(i)
        })


        val mDatabaseRef = FirebaseDatabase.getInstance().getReference("Vendor")

        val query: Query = mDatabaseRef.orderByChild("name").equalTo(username)

        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (data in dataSnapshot.children) {
                    println(data)
                    val models: product? = data.getValue(product::class.java)

//                    val latitude: String = models!!.doctorname
//                    val longitude: String = models!!.Contactnumber
                    sname = models!!.name
                    address = models!!.address
                    mobileno = models!!.number

//                    contact = models.contactnumber
                    txtdname.text = "Address "+address
                    txthname.text = "Name "+sname
                    txthaddress.text = "mobile No "+mobileno



                }

            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })

    }
}