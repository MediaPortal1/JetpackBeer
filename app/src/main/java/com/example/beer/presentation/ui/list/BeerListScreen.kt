package com.example.beer.presentation.ui.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.beer.domain.Beer
import com.example.beer.presentation.state.BeerListState

@Composable
fun BeerListScreen(vm: BeerListVM = hiltViewModel()) {
    Column {
        when(val state = vm.beersState.collectAsState().value){
            is BeerListState.Loading -> {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth(), color = Color.Yellow)
                vm.initBeerListState()
            }
            is BeerListState.Error -> {
                Text(state.message, style = MaterialTheme.typography.body2)
            }
            is BeerListState.Result -> {
                Text("Punk API beers", style = MaterialTheme.typography.h2, modifier = Modifier.padding(20.dp))
                BeerList(state.beers)
            }
        }
    }
}

@Composable
fun BeerList(beers: List<Beer>) {
    LazyColumn{
        beers.forEach {
            item {
                BeerCard(it)
            }
        }
    }
}

@Composable
fun BeerCard(beer: Beer) {
    androidx.compose.material.Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .padding(20.dp, 10.dp)
            .clip(RoundedCornerShape(15.dp))
            .fillMaxWidth(),
    ) {
        Row(Modifier.padding(20.dp)) {
            AsyncImage(
                model = beer.image,
                contentDescription = "Beer image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(100.dp)
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
            )
            Column {
                Text(beer.name, style = MaterialTheme.typography.h3)
                Spacer(Modifier.height(10.dp))
                Text(beer.description, style = MaterialTheme.typography.body1)
            }
        }
    }
}
