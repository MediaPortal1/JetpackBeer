package com.example.beer.data.network.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BeerResponse (
    @field: Json val data: List<BeerResponseItem>,
    )
@JsonClass(generateAdapter = true)
data class BeerResponseItem (
    @field: Json(name = "id") val id: Int,
    @field: Json(name = "name") val name: String,
    @field: Json(name = "tagline") val tagline: String,
    @field: Json(name = "first_brewed") val first_brewed: String,
    @field: Json(name = "description") val description: String,
    @field: Json(name = "image_url") val image_url: String,
    @field: Json(name = "abv") val abv: Float,
    @field: Json(name = "ibu") val ibu: Float,
    @field: Json(name = "target_fg") val target_fg: Float,
    @field: Json(name = "target_og") val target_og: Float,
    @field: Json(name = "ebc") val ebc: Float,
    @field: Json(name = "srm") val srm: Float,
    @field: Json(name = "ph") val ph: Float,
    @field: Json(name = "attenuation_level") val attenuation_level: Float,
    @field: Json(name = "volume") val volume: List<ValueUnit>,
    @field: Json(name = "boil_volume") val boil_volume: List<ValueUnit>,
    @field: Json(name = "method") val method: Method,
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

