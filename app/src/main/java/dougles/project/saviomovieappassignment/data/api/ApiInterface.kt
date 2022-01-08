package dougles.project.saviomovieappassignment.data.api

import dougles.project.saviomovieappassignment.data.model.MoviesApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

//    @GET("Dcosta2205/cd3bf4cfdf6911fb26ae95672adb468e/raw/62d68fac146598cdba379317011ac9aa1aca8621/movies_db")
//    suspend fun getMoviesFromApi(): ResponseDTO


    @GET("3/discover/movie")
    suspend fun getMoviesFromMoviesApi(
        @Query("api_key") apiKey: String, @Query("page") page: Int
    ): MoviesApiResponse
}