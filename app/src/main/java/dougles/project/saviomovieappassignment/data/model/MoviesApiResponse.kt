package dougles.project.saviomovieappassignment.data.model

import com.google.gson.annotations.SerializedName

data class MoviesApiResponse(

    @field:SerializedName("page")
	val page: Int? = null,

    @field:SerializedName("results")
	val results: List<MoviesApiResults?>? = null,

    @field:SerializedName("total_pages")
	val totalPages: Int? = null,

    @field:SerializedName("total_results")
	val totalResults: Int? = null
)