package com.example.beer.data.network.repo

import com.example.beer.data.network.api.BeerAPI
import com.example.beer.data.network.api.model.BeerResponse
import com.example.beer.data.network.api.model.BeerResponseItem
import com.example.beer.data.network.api.model.BeerResponseItemJsonAdapter
import com.example.beer.data.network.api.model.BeerResponseJsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BeerRepository @Inject constructor(
    private val api: BeerAPI,
    ) {

    @Throws(Exception::class)
    suspend fun loadSomeBeers() : BeerResponse {
        return withContext(Dispatchers.IO) {
            val body = api.getBeersFromApi()
            val beerItems = BeerResponseJsonAdapter(Moshi.Builder().build()).fromJson(body.string())
            return@withContext beerItems!!
        }
    }
}