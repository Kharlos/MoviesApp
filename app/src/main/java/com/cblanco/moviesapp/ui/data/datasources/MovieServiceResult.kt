package com.cblanco.moviesapp.ui.data.datasources

import com.google.gson.annotations.SerializedName


class MovieServiceResult(
    @SerializedName("page")
    var page: Int?, // 1
    @SerializedName("results")
    var results: List<MovieResult>?,
    @SerializedName("total_pages")
    var totalPages: Int?, // 500
    @SerializedName("total_results")
    var totalResults: Int? // 10000
)

data class MovieResult(
    @SerializedName("adult")
    var adult: Boolean?, // false
    @SerializedName("backdrop_path")
    var backdropPath: String?, // /uAQrHntCccFpvxp75XdQgqexlJd.jpg
    @SerializedName("genre_ids")
    var genreIds: List<Int>?,
    @SerializedName("id")
    var id: Int?, // 508943
    @SerializedName("original_language")
    var originalLanguage: String?, // en
    @SerializedName("original_title")
    var originalTitle: String?, // Luca
    @SerializedName("overview")
    var overview: String?, // Luca and his best friend Alberto experience an unforgettable summer on the Italian Riviera. But all the fun is threatened by a deeply-held secret: they are sea monsters from another world just below the water’s surface.
    @SerializedName("popularity")
    var popularity: Double?, // 5454.689
    @SerializedName("poster_path")
    var posterPath: String?, // /jTswp6KyDYKtvC52GbHagrZbGvD.jpg
    @SerializedName("release_date")
    var releaseDate: String?, // 2021-06-17
    @SerializedName("title")
    var title: String?, // Luca
    @SerializedName("video")
    var video: Boolean?, // false
    @SerializedName("vote_average")
    var voteAverage: Double?, // 8.2
    @SerializedName("vote_count")
    var voteCount: Int? // 1735
)