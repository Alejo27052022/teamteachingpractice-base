package com.example.teamteachingpractice.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileteamteaching.R
import com.example.teamteachingpractice.adapter.CharacterAdapter
import com.example.teamteachingpractice.data.Character
import com.example.teamteachingpractice.services.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Pantalla : ComponentActivity() {
    private val retrofitService by lazy {
        RetrofitInstance.getRetrofitService()
    }

    private lateinit var recyclerView: RecyclerView
    private val character = mutableListOf<Character>()
    private lateinit var characterAdapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantallaweb)

        /* Configuracion de Recyclerview */
        recyclerView = findViewById(R.id.recycler)
        characterAdapter = CharacterAdapter(character)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = characterAdapter

        fetch()
    }

    private fun fetch(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val respuesta = retrofitService.getCharacters()
                withContext(Dispatchers.Main){
                    character.clear()
                    character.addAll(respuesta)
                    characterAdapter.notifyDataSetChanged()
                }
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

}