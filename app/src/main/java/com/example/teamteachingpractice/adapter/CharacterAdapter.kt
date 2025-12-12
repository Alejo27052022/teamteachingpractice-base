package com.example.teamteachingpractice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mobileteamteaching.R
import com.example.teamteachingpractice.data.Character

class CharacterAdapter(private val characters: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.AdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character, parent, false)
        return AdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int){
        val item = characters[position]

        holder.personaje.text = item.nombre

        Glide.with(holder.itemView.context).load(item.imagen).into(holder.imagen)
    }

    override fun getItemCount() = characters.size

    class AdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imagen : ImageView = itemView.findViewById(R.id.photo)
        val personaje : TextView = itemView.findViewById(R.id.nom_character)
    }
}