package com.ashana.caching.beerworld.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ashana.caching.beerworld.data.remote.domain.Beer
import com.ashana.caching.beerworld.ui.theme.BeerWorldTheme

@Composable
fun BeerItem(
    beer: Beer,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = 4.dp
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .padding(16.dp)
        ) {
            AsyncImage(
                model = beer.imageUrl,
                contentDescription = beer.name,
                modifier = modifier
                    .weight(1f)
                    .height(150.dp)
            )
            Spacer(modifier = modifier.width(16.dp))
            Column(
                modifier = modifier
                    .weight(3f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = beer.name,
                    style = MaterialTheme.typography.h6,
                    modifier = modifier.fillMaxWidth()
                )
                Text(
                    text = beer.tagLine,
                    fontStyle = FontStyle.Italic,
                    color = Color.LightGray,
                    modifier = modifier.fillMaxWidth()
                )
                Spacer(modifier = modifier.height(8.dp))
                Text(
                    text = beer.description,
                    modifier = modifier.fillMaxWidth()
                )
                Spacer(modifier = modifier.height(4.dp))
                Text(
                    text = "First brewed in ${beer.firstBrewed}",
                    fontSize = 8.sp,
                    textAlign = TextAlign.End,
                    modifier = modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
@Preview
fun BeerItemPreview() {
    BeerWorldTheme {
        BeerItem(beer = Beer(
            id = 1,
            name = "Lion",
            tagLine = "This is a tag line",
            firstBrewed = "27/07/2023",
            description = "This suppose to be a description!",
            imageUrl = null
        ))
    }
}