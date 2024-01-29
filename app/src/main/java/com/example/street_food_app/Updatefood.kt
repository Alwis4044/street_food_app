package com.example.street_food_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Updatefood : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private val db = FirebaseDatabase.getInstance()
    private val root = db.reference.child("data")

    private var adapter: UpdateAdapter? = null
    private var list: ArrayList<MyFood?>? = null
    var ref: DatabaseReference? = null
    var searchView: SearchView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updatefood)

        val pref = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val name = pref.getString("name", "")
        Toast.makeText(applicationContext,name.toString(), Toast.LENGTH_LONG).show()


        val recyclerView = findViewById<RecyclerView>(R.id.recylerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val mDatabaseRef = FirebaseDatabase.getInstance().getReference("hotel")

//        val options: FirebaseRecyclerOptions<MyFood> = FirebaseRecyclerOptions.Builder<MyFood>()
//            .setQuery(FirebaseDatabase.getInstance().reference.child("hotel").equalTo("sai hotel"), MyFood::class.java)
//            .build()

        val options: FirebaseRecyclerOptions<MyFood> = FirebaseRecyclerOptions.Builder<MyFood>()
            .setQuery(mDatabaseRef.orderByChild("shopname").equalTo(name), MyFood::class.java)
            .build()

        adapter = UpdateAdapter(options,this)
        recyclerView.setAdapter(adapter)
    }


    override fun onStart() {
        super.onStart()
        adapter!!.startListening()
    }
    override fun onStop() {
        super.onStop()
        adapter!!.stopListening()
    }

}