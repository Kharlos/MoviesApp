package com.cblanco.moviesapp.ui.data.model


import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id")
    var id: Int?, // 28
    @SerializedName("name")
    var name: String? // Action
)