package com.example.street_food_app

import android.annotation.SuppressLint
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class adminregister : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null




    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adminregister)


        val name = findViewById<EditText>(R.id.edname)

        val number = findViewById<EditText>(R.id.ednumber)
        val email = findViewById<EditText>(R.id.edemail)
        val password = findViewById<EditText>(R.id.edpassword)
        val address = findViewById<EditText>(R.id.edaddress)


        val btn = findViewById<Button>(R.id.btnregister)


        auth = FirebaseAuth.getInstance()

        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("Vendor")

        btn.setOnClickListener {
            if(name.text.isEmpty())
            {
                name.setError("Enter name")
                return@setOnClickListener
            }else if(password.text.isEmpty())
            {
                password.setError("Enter Password ")
                return@setOnClickListener
            }else if(number.text.isEmpty())
            {
                number.setError("Enter Contact Number")
                return@setOnClickListener
            }else if(email.text.isEmpty())
            {
                email.setError("Enter Email id")
                return@setOnClickListener
            }


            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful)
                    {

                        val currentuser = auth.currentUser
                        val id = currentuser?.uid

                        val currentUserdb = databaseReference?.child((currentuser?.uid!!))
                        currentUserdb?.child("name")?.setValue(name.text.toString())
                        currentUserdb?.child("address")?.setValue(address.text.toString())
                        currentUserdb?.child("number")?.setValue(number.text.toString())

                        Toast.makeText(applicationContext,"success", Toast.LENGTH_LONG).show()
                        println(id);
                        System.out.println(id);
                        if (id != null) {
                            sharedata(name.text.toString(),id,email.text.toString())
                        }

                        getlocation(address.text.toString(),name.text.toString())


//                        Toast.makeText(applicationContext,adhar.text.toString(), Toast.LENGTH_LONG).show()


                    }
                    else
                    {
                        Toast.makeText(applicationContext,"failed", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }

    private fun getlocation(strAddress: String, name: String) {

        val coder = Geocoder(this)
        var address: List<Address?>


        address = coder.getFromLocationName(strAddress, 5);

        val location = address[0]!!
        val latLng = LatLng(location.latitude, location.longitude)
        val lati = location.latitude.toString()
        val longi = location.longitude.toString()

        val data = FirebaseDatabase.getInstance().reference.child("location")

        val user = userlocation(lati,longi,name)

        data.push().setValue(user)





    }

    private fun sharedata(name: String, id: String, mail: String) {


        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)


        val myEdit = sharedPreferences.edit()


        myEdit.putString("id", id)
        myEdit.putString("name",name)
        myEdit.putString("mail",mail)

        myEdit.commit()


    }
}