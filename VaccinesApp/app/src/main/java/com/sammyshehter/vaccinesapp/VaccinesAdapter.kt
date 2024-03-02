package com.sammyshehter.vaccinesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class VaccinesAdapter(val vaccinesList: ArrayList<VaccinesModel>)
    :RecyclerView.Adapter<VaccinesAdapter.VaccinesViewHolder >(){

    inner class VaccinesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var vaccineImage: ImageView
        var vaccineTitle: TextView

        init {
            vaccineImage = itemView.findViewById(R.id.imageView)
            vaccineTitle = itemView.findViewById(R.id.text1)

            itemView.setOnClickListener(){
                Toast.makeText(itemView.context, "You choose ${vaccinesList[adapterPosition].name}", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccinesViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout, parent, false)

        return VaccinesViewHolder(v)
    }

    override fun onBindViewHolder(holder: VaccinesViewHolder, position: Int) {
        holder.vaccineTitle.setText(vaccinesList[position].name)
        holder.vaccineImage.setImageResource(vaccinesList[position].img)
    }

    override fun getItemCount(): Int {
        return vaccinesList.size
    }
}