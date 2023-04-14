package com.ashana.caching.beerworld.presentation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.ashana.caching.beerworld.data.remote.domain.Beer

@Composable
fun BeerScreen(
    beer: LazyPagingItems<Beer>
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = beer.loadState) {
        if (beer.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context, "Error! ${(beer.loadState.refresh as LoadState.Error).error.message}",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}