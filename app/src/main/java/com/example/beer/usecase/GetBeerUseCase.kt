package com.example.beer.usecase

import com.example.beer.data.network.api.convert.BeerModelConverter
import com.example.beer.data.network.repo.BeerRepository
import com.example.beer.presentation.state.BeerListState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetBeerUseCase @Inject constructor(private val repository: BeerRepository) {

    @Throws(Exception::class)
    suspend fun onLoadBeer(): BeerListState {
        return try {
            val response = repository.loadSomeBeers()
            val beers = BeerModelConverter.convertBeerResponseToList(response.data)
            BeerListState.Result(beers)
        } catch (e: Exception) {
            BeerListState.Error(e.message ?: "Unknown error")
        }
    }
}