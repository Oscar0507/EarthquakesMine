package com.example.earthquakesmine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.earthquakesmine.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Assigning layout for the Recycler view
        binding.eqRecycler.layoutManager=LinearLayoutManager(this)

        val eqList:MutableList<Earthquake> = mutableListOf<Earthquake>()
        eqList.add(Earthquake("1","City1",7.5,44444444,-238.32,127.65))
        eqList.add(Earthquake("2","City2",7.5,44444444,-238.32,127.65))
        eqList.add(Earthquake("3","City3",7.5,44444444,-238.32,127.65))
        eqList.add(Earthquake("4","City4",7.5,44444444,-238.32,127.65))
        eqList.add(Earthquake("5","City5",7.5,44444444,-238.32,127.65))
        eqList.add(Earthquake("6","City6",7.5,44444444,-238.32,127.65))
        eqList.add(Earthquake("7","City7",7.5,44444444,-238.32,127.65))

        val adapter=EqAdapter()
        binding.eqRecycler.adapter=adapter
        adapter.submitList(eqList)


    }
}