package com.cblanco.moviesapp.ui.data.model


import com.google.gson.annotations.SerializedName

data class RemoteMovieDetail(
    @SerializedName("adult")
    var adult: Boolean?, // false
    @SerializedName("backdrop_path")
    var backdropPath: String?, // /dq18nCTTLpy9PmtzZI6Y2yAgdw5.jpg
    @SerializedName("belongs_to_collection")
    var belongsToCollection: Any?, // null
    @SerializedName("budget")
    var budget: Int?, // 200000000
    @SerializedName("genres")
    var genres: List<Genre>?,
    @SerializedName("homepage")
    var homepage: String?, // https://www.marvel.com/movies/black-widow
    @SerializedName("id")
    var id: Int?, // 497698
    @SerializedName("imdb_id")
    var imdbId: String?, // tt3480822
    @SerializedName("original_language")
    var originalLanguage: String?, // en
    @SerializedName("original_title")
    var originalTitle: String?, // Black Widow
    @SerializedName("overview")
    var overview: String?, // Natasha Romanoff, also known as Black Widow, confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises. Pursued by a force that will stop at nothing to bring her down, Natasha must deal with her history as a spy and the broken relationships left in her wake long before she became an Avenger.
    @SerializedName("popularity")
    var popularity: Double?, // 10297.406
    @SerializedName("poster_path")
    var posterPath: String?, // /qAZ0pzat24kLdO3o8ejmbLxyOac.jpg
    @SerializedName("production_companies")
    var productionCompanies: List<ProductionCompany>?,
    @SerializedName("production_countries")
    var productionCountries: List<ProductionCountry>?,
    @SerializedName("release_date")
    var releaseDate: String?, // 2021-07-07
    @SerializedName("revenue")
    var revenue: Int?, // 224800430
    @SerializedName("runtime")
    var runtime: Int?, // 134
    @SerializedName("spoken_languages")
    var spokenLanguages: List<SpokenLanguage>?,
    @SerializedName("status")
    var status: String?, // Released
    @SerializedName("tagline")
    var tagline: String?, // She's Done Running From Her Past.
    @SerializedName("title")
    var title: String?, // Black Widow
    @SerializedName("video")
    var video: Boolean?, // false
    @SerializedName("vote_average")
    var voteAverage: Double?, // 8.1
    @SerializedName("vote_count")
    var voteCount: Int? // 2597
)