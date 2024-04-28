package com.example.zooapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.zooapp.databinding.ActivityMainBinding
import com.example.zooapp.databinding.AnimalTicketBinding


class MainActivity : AppCompatActivity() {
    private var listOfAnimal= ArrayList<Animal>()
    var adaptor:AnimalsAdaptor?=null
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //load animals
        listOfAnimal.add(Animal("Tiger","One of the animal that live in forest",R.drawable.img_tiger))

        listOfAnimal.add(Animal("Panda","Laziest animal",R.drawable.img_panda))

        listOfAnimal.add(Animal("Zebra","One of the animal that live in forest",R.drawable.img_zebra))

        listOfAnimal.add(Animal("Tiger","Animal",R.drawable.img_tiger))
        listOfAnimal.add(Animal("Tiger","Animal 2",R.drawable.img_tiger))
        listOfAnimal.add(Animal("Tiger","Animal 3",R.drawable.img_tiger))

        adaptor= AnimalsAdaptor(this,listOfAnimal)
        binding.rvAnimals.adapter = adaptor

    }
    class AnimalsAdaptor:BaseAdapter{
        var listOfAnimal = ArrayList<Animal>()
        var context: Context?= null
        constructor(context: Context ,listOfAnimal: ArrayList<Animal>): super(){
                this.listOfAnimal = listOfAnimal
                this.context = context
        }
        override fun getCount(): Int {
           return listOfAnimal.size
        }

        override fun getItem(p0: Int): Any {
           return listOfAnimal[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
          val animal =listOfAnimal[p0]
            val inflator = LayoutInflater.from(context)
            val myView = AnimalTicketBinding.inflate(inflator)
            myView.tvTitle.text = animal.name
            myView.tvSubTitle.text = animal.des
            myView.ivImg.setBackgroundResource(animal.image!!)
            return myView.root
        }
    }

}