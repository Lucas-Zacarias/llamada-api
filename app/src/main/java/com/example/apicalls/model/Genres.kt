package com.example.apicalls.model

import com.google.gson.annotations.SerializedName

data class Genres(
    @SerializedName(value = "genres")
    var genres: Map<Int,String>
)