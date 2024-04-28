package com.example.zooapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.example.zooapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var listOfAnimal = ArrayList<Animal>()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //load animals
        listOfAnimal.add(
            Animal(
                "Tiger",
                "One of the animal that live in forest",
                R.drawable.img_tiger
            )
        )

        listOfAnimal.add(Animal("Panda", "Laziest animal", R.drawable.img_panda))

        listOfAnimal.add(
            Animal(
                "Zebra",
                "One of the animal that live in forest",
                R.drawable.img_zebra
            )
        )

        listOfAnimal.add(Animal("Tiger", "Animal", R.drawable.img_tiger))
        listOfAnimal.add(Animal("Tiger", "Animal 2", R.drawable.img_tiger))
        listOfAnimal.add(Animal("Tiger", "Animal 3", R.drawable.img_tiger))
        listOfAnimal.add(Animal("Tiger", "Animal 4", R.drawable.img_tiger))
        listOfAnimal.add(Animal("Tiger", "Animal 5", R.drawable.img_tiger))
        binding.rvAnimals.adapter = AnimalAdapter( listOfAnimal) { data ->
            val intent = Intent(this, animaldetailsaction::class.java)
            val bundle  = bundleOf("ANIMAL" to data)
            intent.putExtras(bundle)
            startActivity(intent)

        }
    }
}

