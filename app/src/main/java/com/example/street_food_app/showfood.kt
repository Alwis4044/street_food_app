package com.example.street_food_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class showfood : AppCompatActivity() {


    var ref: DatabaseReference? = null
    var list: ArrayList<MyFood>? = null
    private var listener: ShowAdapter.RecyclerViewClickListener? = null

    var recyclerView: RecyclerView? = null

    var searchView: SearchView? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showfood)

        ref = FirebaseDatabase.getInstance().reference.child("hotel")
        recyclerView = findViewById(R.id.recyclerview)
        searchView = findViewById(R.id.searchview)
    }


    override fun onStart() {
        super.onStart()
        if (ref != null) {
            ref!!.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        list = ArrayList()
                        for (ds in snapshot.children) {
                            list!!.add(ds.getValue(MyFood::class.java)!!)
                        }
                        setOnClickListner()
                        val adapter = ShowAdapter(list, listener)
                        recyclerView!!.adapter = adapter
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@showfood, "error", Toast.LENGTH_SHORT).show()
                }
            })
        }


        if (searchView != null) {
            searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(s: String): Boolean {
                    return false
                }

                override fun onQueryTextChange(s: String): Boolean {
                    search(s)
                    return true
                }
            })
        }
    }

    private fun setOnClickListner() {

        listener = ShowAdapter.RecyclerViewClickListener { v, position ->
            val intent = Intent(applicationContext, productdetails::class.java)
            intent.putExtra("proname", list!![position].shopname)
            intent.putExtra("material",list!![position].address)
            intent.putExtra("manifacture",list!![position].number)
            intent.putExtra("origin",list!![position].food1)
            intent.putExtra("weight",list!![position].food2)
            intent.putExtra("rating",list!![position].food3)
            intent.putExtra("dimension",list!![position].food4)

            intent.putExtra("url",list!![position].imageurl)


            startActivity(intent)
        }
    }

    private fun search(s: String) {


        try{
            val mylist = ArrayList<MyFood?>()
            for (`object` in list!!) {
                if (`object`!!.address.toLowerCase().contains(s.toLowerCase())) {
                    mylist.add(`object`)
                }
            }
            val adapter = ShowAdapter(mylist,listener)
            recyclerView!!.adapter = adapter
        }catch (e:Exception){
            e.printStackTrace()
        }

    }

}