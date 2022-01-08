package dougles.project.saviomovieappassignment.ui.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dougles.project.saviomovieappassignment.data.api.RetrofitBuilder
import dougles.project.saviomovieappassignment.data.model.MoviesApiResults
import java.lang.Exception

class PaginationSource : PagingSource<Int, MoviesApiResults>() {
    private val api = RetrofitBuilder().getApiService()
    override fun getRefreshKey(state: PagingState<Int, MoviesApiResults>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MoviesApiResults> {
        val pagenum = params.key ?: 1
        val moviesApiResponse =
            api.getMoviesFromMoviesApi("328c283cd27bd1877d9080ccb1604c91", pagenum)
        val movieResult: List<MoviesApiResults> =
            (moviesApiResponse?.results as List<MoviesApiResults>?)!!

        return try {
            LoadResult.Page(
                data = movieResult,
                prevKey = null,
                nextKey = if (movieResult.isEmpty()) null else pagenum + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}