package dougles.project.saviomovieappassignment.ui.pagination

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData

class PagingRepo {

    fun getpages() = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = { PaginationSource() }).liveData
}