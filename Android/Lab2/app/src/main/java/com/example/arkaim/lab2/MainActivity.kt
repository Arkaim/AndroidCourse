package com.example.arkaim.lab2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.res.Configuration
import android.service.autofill.Dataset
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var dataset: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null) {
            dataset = savedInstanceState.getParcelableArrayList("dataset")
        }
        else {
            dataset = ArrayList()
        }

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.layoutManager = GridLayoutManager(this, 3)
        } else {
            recyclerView.layoutManager = LinearLayoutManager(this)
        }

        recyclerView.adapter = UserAdapter(this, dataset)

        button.setOnClickListener {
            dataset.add(User("Johny Depp", "Pirates of the Caribbean"))
            this.recyclerView.adapter!!.notifyDataSetChanged()
        }



    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putParcelableArrayList("dataset", dataset)
    }
}
