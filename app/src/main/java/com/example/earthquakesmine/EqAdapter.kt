package com.example.earthquakesmine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class EqAdapter: ListAdapter<Earthquake,EqAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback:DiffUtil.ItemCallback<Earthquake>(){

        override fun areItemsTheSame(oldItem: Earthquake, newItem: Earthquake): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Earthquake, newItem: Earthquake): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EqAdapter.ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.eq_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: EqAdapter.ViewHolder, position: Int) {
        val earthquake:Earthquake=getItem(position)
        holder.magnitudeText.text=earthquake.magnitude.toString()
        holder.placeText.text=earthquake.place
    }
    inner class ViewHolder(val view:View):RecyclerView.ViewHolder(view){
        val magnitudeText: TextView =view.findViewById<TextView>(R.id.txt_eq_magnitude)
        val placeText=view.findViewById<TextView>(R.id.txt_eq_place)
    }
}