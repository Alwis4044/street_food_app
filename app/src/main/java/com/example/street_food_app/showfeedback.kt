package com.example.street_food_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class showfeedback : AppCompatActivity() {

    var ref: DatabaseReference? = null
    var list: ArrayList<feed>? = null
    private var listener: ShowsAdapter.RecyclerViewClickListener? = null

    var recyclerView: RecyclerView? = null

//    var searchView: SearchView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showfeedback)

        ref = FirebaseDatabase.getInstance().reference.child("Feedback")
        recyclerView = findViewById(R.id.recyclerview)
//        searchView = findViewById(R.id.searchview)

    }

    override fun onStart() {
        super.onStart()
        if (ref != null) {
            ref!!.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        list = ArrayList()
                        for (ds in snapshot.children) {
                            list!!.add(ds.getValue(feed::class.java)!!)
                        }
//                        setOnClickListner()
                        val adapter = ShowsAdapter(list, listener)
                        recyclerView!!.adapter = adapter
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@showfeedback, "error", Toast.LENGTH_SHORT).show()
                }
            })
        }


//        if (searchView != null) {
//            searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//                override fun onQueryTextSubmit(s: String): Boolean {
//                    return false
//                }
//
//                override fun onQueryTextChange(s: String): Boolean {
//                    search(s)
//                    return true
//                }
//            })
//        }
    }



        private fun search(s: String) {

            try{
                val mylist = ArrayList<feed?>()
                for (`object` in list!!) {
                    if (`object`!!.getRating().toLowerCase().contains(s.toLowerCase())) {
                        mylist.add(`object`)
                    }
                }
                val adapter = ShowsAdapter(mylist,listener)
                recyclerView!!.adapter = adapter
            }catch (e:Exception){
                e.printStackTrace()
            }

        }
    }
