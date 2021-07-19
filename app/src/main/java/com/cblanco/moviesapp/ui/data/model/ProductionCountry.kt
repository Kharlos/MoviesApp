package com.cblanco.moviesapp.ui.data.model


import com.google.gson.annotations.SerializedName

data class ProductionCountry(
    @SerializedName("iso_3166_1")
    var iso31661: String?, // US
    @SerializedName("name")
    var name: String? // United States of America
)