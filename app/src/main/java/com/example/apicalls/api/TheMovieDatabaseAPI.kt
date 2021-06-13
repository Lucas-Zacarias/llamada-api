package com.example.apicalls.api

import com.example.apicalls.model.Genres
import retrofit2.Call
import retrofit2.http.GET

interface TheMovieDatabaseAPI {

    companion object{

        const val API_KEY: String = "75baaa3bb4acacdaa5f27d938049e8ce"
        const val LANGUAGE_SPANISH : String = "es"
    }

    @GET("genre/movie/list?api_key=${API_KEY}&language=${LANGUAGE_SPANISH}")

    fun getGenreList() : Call<Genres>

}