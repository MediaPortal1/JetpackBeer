package com.example.beer.data.network.repo

import com.example.beer.data.network.api.BeerAPI
import com.example.beer.data.network.api.model.BeerResponse
import com.example.beer.data.network.api.model.BeerResponseItem
import com.example.beer.data.network.api.model.BeerResponseItemJsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
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
            val jsonBody = JSONArray(body.string())
            val items = mutableListOf<BeerResponseItem>()
            for (i in 0 until jsonBody.length()) {
                BeerResponseItemJsonAdapter(Moshi.Builder().build()).fromJson((jsonBody[i] as JSONObject).toString())
                    ?.let { items.add(it) }
            }
            return@withContext BeerResponse(items)
        }
    }
}