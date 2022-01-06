package dougles.project.saviomovieappassignment.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dougles.project.saviomovieappassignment.data.api.RetrofitBuilder
import dougles.project.saviomovieappassignment.data.model.ResponseDTO

class MoviesRepository(context: Context) {
    private val apiService = RetrofitBuilder().getApiService()
    private val moviesLiveData = MutableLiveData<ResponseDTO>()
    val movies: LiveData<ResponseDTO>
        get() = moviesLiveData

    suspend fun getMoviesFromApi() {
        val responseFromApi = apiService.getMoviesFromApi()
        if (responseFromApi.body() != null) {
            moviesLiveData.postValue(responseFromApi.body())
        }
    }
}