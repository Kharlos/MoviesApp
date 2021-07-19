package com.cblanco.moviesapp.ui.data.model


import com.google.gson.annotations.SerializedName

data class ProductionCompany(
    @SerializedName("id")
    var id: Int?, // 420
    @SerializedName("logo_path")
    var logoPath: String?, // /hUzeosd33nzE5MCNsZxCGEKTXaQ.png
    @SerializedName("name")
    var name: String?, // Marvel Studios
    @SerializedName("origin_country")
    var originCountry: String? // US
)