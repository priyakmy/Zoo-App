package com.example.zooapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.zooapp.databinding.AnimalTicketBinding


class AnimalAdapter(private val data:List<Animal>, val onClick:(Animal)->Unit) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {


    inner class AnimalViewHolder(val binding:AnimalTicketBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val itemBinding = AnimalTicketBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return AnimalViewHolder(itemBinding)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        with(holder.binding) {
            tvTitle.text = data.get(position).name
            tvSubTitle.text = data.get(position).des
            ivImg.setImageResource(data.get(position).image!!)

            cardView.setOnClickListener {
                onClick.invoke(data.get(position))
            }

        }
    }



}
