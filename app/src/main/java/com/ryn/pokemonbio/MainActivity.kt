package com.ryn.pokemonbio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvPokemon: RecyclerView
    private val list = ArrayList<Pokemon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPokemon = findViewById(R.id.rv_pokemon)
        rvPokemon.setHasFixedSize(true)

        list.addAll(getListPokemon())
        showRecyclerList()
    }

    private fun getListPokemon(): ArrayList<Pokemon> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listPokemon = ArrayList<Pokemon>()
        for (i in dataName.indices) {
            val pokemon = Pokemon(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listPokemon.add(pokemon)
        }
        return listPokemon
    }

    private fun showRecyclerList() {
        rvPokemon.layoutManager = LinearLayoutManager(this)
        val listPokemonAdapter = ListPokemonAdapter(list)
        rvPokemon.adapter = listPokemonAdapter
    }
}
