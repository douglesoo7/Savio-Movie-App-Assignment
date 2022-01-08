package dougles.project.saviomovieappassignment.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dougles.project.saviomovieappassignment.data.model.MoviesApiResponse
import dougles.project.saviomovieappassignment.data.api.RetrofitBuilder

class MoviesRepository() {
    private val apiService = RetrofitBuilder().getApiService()

    private val moviesNowShowingLiveData = MutableLiveData<MoviesApiResponse>()

    val responseMovies: LiveData<MoviesApiResponse>
        get() = moviesNowShowingLiveData

    suspend fun getResponseFromMoviesApi() {
        val moviesApiResponse =
            apiService.getMoviesFromMoviesApi("328c283cd27bd1877d9080ccb1604c91", 1)
        if (moviesApiResponse != null) {
            Log.d("MoviesApi", moviesApiResponse.toString())
            moviesNowShowingLiveData.postValue(moviesApiResponse)
        }
    }
}