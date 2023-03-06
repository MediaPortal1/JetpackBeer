package com.example.beer.presentation.state

import com.example.beer.domain.Beer

interface BeerListState {
    object Loading : BeerListState
    data class Result(val beers: List<Beer>) : BeerListState
    data class Error(val message: String) : BeerListState
}