package dougles.project.saviomovieappassignment.ui.viewmodel

import androidx.lifecycle.*
import dougles.project.saviomovieappassignment.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import dougles.project.saviomovieappassignment.data.model.MoviesApiResponse
import dougles.project.saviomovieappassignment.ui.pagination.PagingRepo
import kotlinx.coroutines.launch

class MoviesViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {

    private val repository = PagingRepo() // for fetching data

    fun paging() = repository.getpages()

    fun getNowShowingResponseFromMoviesApi() {
        viewModelScope.launch(Dispatchers.IO) {
            moviesRepository.getResponseFromMoviesApi()
        }
    }

    val responseNowShowing: LiveData<MoviesApiResponse>
        get() = moviesRepository.responseMovies


}