package com.example.beer.data.network.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class BeerResponse (
val data: List<BeerResponseItem>,
)
@JsonClass(generateAdapter = true)
data class BeerResponseItem (
    @field: Json(name = "id") val id: Int,
    @field: Json(name = "name") val name: String,
    @field: Json(name = "tagline") val tagline: String,
    @field: Json(name = "first_brewed") val first_brewed: String,
    @field: Json(name = "description") val description: String,
    @field: Json(name = "image_url") val image_url: String,

)

@JsonClass(generateAdapter = true)
data class ValueUnit (
    @field: Json(name = "value") val value: Int,
    @field: Json(name = "unit") val unit: String,
)


@JsonClass(generateAdapter = true)
data class Method (
    @field: Json(name = "mash_temp") val mashTemp: List<MashTemp>,
    @field: Json(name = "fermentation") val fermentation: List<Fermentation>,
    @field: Json(name = "twist") val twist: String,
)

@JsonClass(generateAdapter = true)
data class MashTemp (
    @field: Json(name = "temp") val temp: List<ValueUnit>,
    @field: Json(name = "duration") val duration: Int,
)


@JsonClass(generateAdapter = true)
data class Fermentation (
    @field: Json(name = "temp") val mashTemp: ValueUnit,
)

