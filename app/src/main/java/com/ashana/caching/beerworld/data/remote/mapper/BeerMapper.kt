package com.ashana.caching.beerworld.data.remote.mapper

import com.ashana.caching.beerworld.data.remote.BeerDto
import com.ashana.caching.beerworld.data.remote.domain.Beer
import com.ashana.caching.beerworld.data.remote.local.BeerEntity

fun BeerDto.toBeerEntity(): BeerEntity {
    return BeerEntity(
        id = id,
        name = name,
        tagLine = tagline,
        description = description,
        firstBrewed = first_brewed,
        imageUrl = image_url
    )
}

fun BeerEntity.toBeer(): Beer {
    return Beer(
        id = id,
        name = name,
        tagLine = tagLine,
        description = description,
        firstBrewed = firstBrewed,
        imageUrl = imageUrl
    )
}