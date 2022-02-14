package com.priambudi19.pagingnormal

import androidx.lifecycle.ViewModel
import com.priambudi19.pagingnormal.data.repo.MovieRepository
import com.priambudi19.pagingnormal.data.repo.MovieRepositoryImpl


class MainViewModel : ViewModel() {
    private val repo : MovieRepository = MovieRepositoryImpl()
    fun getListMovie() = repo.getListMovie()
}