package com.priambudi19.pagingnormal.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.priambudi19.pagingnormal.data.model.Movie
import com.priambudi19.pagingnormal.databinding.MovieItemBinding

class TmdbPagingAdapter :
    PagingDataAdapter<Movie, TmdbPagingAdapter.MovieViewHolder>(MovieComparator) {

    object MovieComparator : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class MovieViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            with(binding) {
                imgPoster.load("https://image.tmdb.org/t/p/w185/${movie.posterPath}") {
                    transformations(RoundedCornersTransformation(8f))
                }
                txtTitle.text = movie.title
                txtRelease.text = movie.releaseDate
            }
        }
    }
}