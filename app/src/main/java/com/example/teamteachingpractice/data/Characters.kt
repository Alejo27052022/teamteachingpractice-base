package com.example.teamteachingpractice.data

import com.google.gson.annotations.SerializedName

data class Character (
    @SerializedName("name") val nombre: String,
    @SerializedName("photo") val imagen: String
)