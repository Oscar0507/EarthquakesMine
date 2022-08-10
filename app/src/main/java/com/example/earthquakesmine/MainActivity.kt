package com.example.earthquakesmine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
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
//        eqList.add(Earthquake("1","City1",7.5,44444444,-238.32,127.65))
//        eqList.add(Earthquake("2","City2",7.5,44444444,-238.32,127.65))
//        eqList.add(Earthquake("3","City3",7.5,44444444,-238.32,127.65))
//        eqList.add(Earthquake("4","City4",7.5,44444444,-238.32,127.65))
//        eqList.add(Earthquake("5","City5",7.5,44444444,-238.32,127.65))
//        eqList.add(Earthquake("6","City6",7.5,44444444,-238.32,127.65))
//        eqList.add(Earthquake("7","City7",7.5,44444444,-238.32,127.65))

        // Creating an adapter that manage the recycler items as views
        val adapter=EqAdapter()
        binding.eqRecycler.adapter=adapter
        adapter.submitList(eqList)

        //Text if list of earthquakes is empty
        if (eqList.isEmpty()){
            binding.txtEmptyAdviser.visibility=View.VISIBLE
        } else{
            binding.txtEmptyAdviser.visibility=View.GONE
        }


    }
}