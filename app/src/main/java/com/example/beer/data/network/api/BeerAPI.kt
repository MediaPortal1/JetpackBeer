package com.example.beer.data.network.api

import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.GET

interface BeerAPI {

    @GET("beers")
    suspend fun getBeersFromApi(): ResponseBody

}