package com.priambudi19.pagingnormal.data.repo

import androidx.paging.PagingData
import com.priambudi19.pagingnormal.data.model.Movie
import kotlinx.coroutines.flow.Flow


interface MovieRepository {
    fun getListMovie() : Flow<PagingData<Movie>>
}