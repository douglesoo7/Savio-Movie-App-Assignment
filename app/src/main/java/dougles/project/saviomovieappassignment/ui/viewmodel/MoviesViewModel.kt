package dougles.project.saviomovieappassignment.ui.viewmodel

import androidx.lifecycle.*
import dougles.project.saviomovieappassignment.data.model.ResponseDTO
import dougles.project.saviomovieappassignment.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MoviesViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {

    val moviesLiveData = MutableLiveData<ResponseDTO>()

    fun getResponseFromApi() {
        viewModelScope.launch(Dispatchers.IO) {
            val resultFromApi = moviesRepository.getResponseFromAPI()
        }
    }

    val response: LiveData<ResponseDTO>
        get() = moviesRepository.response

}