package dougles.project.saviomovieappassignment.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dougles.project.saviomovieappassignment.data.api.RetrofitBuilder
import dougles.project.saviomovieappassignment.data.model.NowShowingDTO
import dougles.project.saviomovieappassignment.data.model.ResponseDTO

class MoviesRepository(context: Context) {
    private val apiService = RetrofitBuilder().getApiService()

    private val moviesLiveData = MutableLiveData<ResponseDTO>()
    val response: LiveData<ResponseDTO>
        get() = moviesLiveData

    suspend fun getResponseFromAPI() {
        val response = apiService.getMoviesFromApi()
        if (response != null)
            Log.d("Movies Repository", response.toString())
        moviesLiveData.postValue(response)
    }
}