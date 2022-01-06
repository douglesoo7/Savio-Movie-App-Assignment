package dougles.project.saviomovieappassignment.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dougles.project.saviomovieappassignment.data.model.ResponseDTO
import dougles.project.saviomovieappassignment.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {

    fun getMoviesFromApi() {
        viewModelScope.launch(Dispatchers.IO) {
            moviesRepository.getMoviesFromApi()
        }
    }

    val movie: LiveData<ResponseDTO>
        get() = moviesRepository.movies

}