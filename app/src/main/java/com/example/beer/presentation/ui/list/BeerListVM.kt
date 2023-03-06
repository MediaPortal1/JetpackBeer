package com.example.beer.presentation.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beer.presentation.state.BeerListState
import com.example.beer.usecase.GetBeerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeerListVM @Inject constructor(private val getBeerUseCase: GetBeerUseCase) : ViewModel() {

    private val mBeersListState = MutableStateFlow<BeerListState>(BeerListState.Loading)
    val beersState = mBeersListState.asStateFlow()

    fun initBeerListState(){
        viewModelScope.launch {
            mBeersListState.value = getBeerUseCase.onLoadBeer()
        }
    }
}