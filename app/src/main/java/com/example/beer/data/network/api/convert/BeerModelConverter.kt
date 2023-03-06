package com.example.beer.data.network.api.convert

import com.example.beer.data.network.api.model.BeerResponse
import com.example.beer.data.network.api.model.BeerResponseItem
import com.example.beer.domain.Beer

object BeerModelConverter {

    fun convertBeerResponseToList(s: List<BeerResponseItem>) =

        s.map { beer ->
            Beer(beer.id, beer.name, beer.description, beer.image_url)
        }
}