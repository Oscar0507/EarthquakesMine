package com.example.earthquakesmine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.earthquakesmine.databinding.EqListItemBinding

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
            //Without binding
            //val view:View = LayoutInflater.from(parent.context).inflate(R.layout.eq_list_item,parent,false)
            //return ViewHolder(view)
            //Using biding
            val binding:EqListItemBinding= EqListItemBinding.inflate(LayoutInflater.from(parent.context))
            return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EqAdapter.ViewHolder, position: Int) {
        val earthquake:Earthquake=getItem(position)
        //without databinding
        //holder.magnitudeText.text=earthquake.magnitude.toString()
        //holder.placeText.text=earthquake.place
        holder.bind(earthquake)
    }
    // without databinding
    //inner class ViewHolder(val view:View):RecyclerView.ViewHolder(view){
    //        val magnitudeText: TextView =view.findViewById<TextView>(R.id.txt_eq_magnitude)
    //        val placeText=view.findViewById<TextView>(R.id.txt_eq_place)

        inner class ViewHolder(private val binding: EqListItemBinding):
            RecyclerView.ViewHolder(binding.root){

            fun bind(earthquake: Earthquake){
                binding.txtEqMagnitude.text=earthquake.magnitude.toString()
                binding.txtEqPlace.text=earthquake.place
            }
    }
}