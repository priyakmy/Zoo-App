package com.example.zooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zooapp.databinding.ActivityAnimaldetailsactionBinding

class animaldetailsaction : AppCompatActivity() {

    private lateinit var binding:ActivityAnimaldetailsactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAnimaldetailsactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getIntentData()
    }

    private fun getIntentData() {
        val bundle :Bundle? = intent.extras
        val data : Animal? = bundle?.get("ANIMAL") as? Animal

        setData(data)
    }

    private fun setData(data:Animal?) {
        data?.let {
            binding.tvTitle.text = it.name
            binding.tvSubTitle.text = it.des
            binding.imgTiger.setImageResource(it.image!!)
        }
    }
}