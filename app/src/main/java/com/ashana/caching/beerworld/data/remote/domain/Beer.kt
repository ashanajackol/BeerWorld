package com.ashana.caching.beerworld.data.remote.domain

data class Beer(
    val id: Int,
    val name: String,
    val tagLine: String,
    val firstBrewed: String,
    val description: String,
    val imageUrl: String? = null
)
