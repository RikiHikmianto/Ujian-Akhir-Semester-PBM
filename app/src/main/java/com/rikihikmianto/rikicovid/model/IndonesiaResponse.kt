package com.rikihikmianto.rikicovid.model

data class IndonesiaResponse(
    val name: String,
    val positif: String,
    val sembuh: String,
    val dirawat: String,
    val meninggal: String,
)