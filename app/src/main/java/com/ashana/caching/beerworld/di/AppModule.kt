package com.ashana.caching.beerworld.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.ashana.caching.beerworld.data.remote.BeerAPI
import com.ashana.caching.beerworld.data.remote.BeerRemoteMediator
import com.ashana.caching.beerworld.data.remote.local.BeerDataBase
import com.ashana.caching.beerworld.data.remote.local.BeerEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBeerDatabase(@ApplicationContext context: Context): BeerDataBase {
        return Room.databaseBuilder(
            context,
            BeerDataBase::class.java,
            "beer.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideBeerApi(): BeerAPI{
        return Retrofit.Builder()
            .baseUrl(BeerAPI.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideBeerPager(beerDb: BeerDataBase, beerApi: BeerAPI): Pager<Int, BeerEntity> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = BeerRemoteMediator(
                beerDb = beerDb,
                beerAPI = beerApi
            ),
            pagingSourceFactory = {
                beerDb.dao.pagingSource()
            }
        )
    }
}
