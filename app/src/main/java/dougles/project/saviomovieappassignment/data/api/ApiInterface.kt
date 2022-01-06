package dougles.project.saviomovieappassignment.data.api

import dougles.project.saviomovieappassignment.data.model.ResponseDTO
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("Dcosta2205/cd3bf4cfdf6911fb26ae95672adb468e/raw/62d68fac146598cdba379317011ac9aa1aca8621/movies_db/")
    suspend fun getMoviesFromApi(): Response<ResponseDTO>
}