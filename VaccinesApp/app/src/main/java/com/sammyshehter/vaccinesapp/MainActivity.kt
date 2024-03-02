package com.sammyshehter.vaccinesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val vaccinesList: ArrayList<VaccinesModel> = ArrayList()

        vaccinesList.add(VaccinesModel("COVID-1", R.drawable.vaccine1))
        vaccinesList.add(VaccinesModel("COVID-2", R.drawable.vaccine4))
        vaccinesList.add(VaccinesModel("COVID-3", R.drawable.vaccine5))
        vaccinesList.add(VaccinesModel("COVID-4", R.drawable.vaccine6))
        vaccinesList.add(VaccinesModel("COVID-5", R.drawable.vaccine7))
        vaccinesList.add(VaccinesModel("COVID-6", R.drawable.vaccine8))
        vaccinesList.add(VaccinesModel("COVID-7", R.drawable.vaccine9))

        val vaccinesAdapter = VaccinesAdapter(vaccinesList)

        recyclerView.adapter = vaccinesAdapter
    }
}