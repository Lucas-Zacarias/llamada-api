package com.example.apicalls.api

import com.example.apicalls.model.Genres
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API {

    companion object{

        const val BASE_URL : String = "https://api.themoviedb.org/3/"

    }

    private fun getAPI(): TheMovieDatabaseAPI{
        val retrofit = Retrofit.Builder()
            .baseUrl("${BASE_URL}")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

        return  retrofit.create(TheMovieDatabaseAPI::class.java)
    }

    fun getGenres(): Call<Genres> {
        return getAPI().getGenreList()
    }
}