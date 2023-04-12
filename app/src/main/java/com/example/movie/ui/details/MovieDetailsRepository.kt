package com.example.movie.ui.details

import com.example.movie.data.moviedetails.MovieDetails
import com.example.movie.remote.MovieInterface
import com.example.movie.utils.Constants
import com.example.movie.utils.Result
import com.example.movie.utils.Status

class MovieDetailsRepository(private val movieInterface: MovieInterface) {


    suspend fun getMovieDetails(imdbId: String): Result<MovieDetails> {


        return try {

            val response = movieInterface.getMovieDetails(imdbId, Constants.API_KEY)
            if (response.isSuccessful) {

                Result(Status.SUCCESS, response.body(), null)

            } else {
                Result(Status.ERROR, null, null)
            }


        } catch (e: Exception) {
            Result(Status.ERROR, null, null)
        }


    }


}