package dougles.project.saviomovieappassignment.data.model

import com.google.gson.annotations.SerializedName

data class MoviesApiResults(

	@field:SerializedName("adult")
	val adult: Boolean? = null,

	@field:SerializedName("backdrop_path")
	val backdropPath: Any? = null,

	@field:SerializedName("genre_ids")
	val genreIds: List<Int?>? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("original_language")
	val originalLanguage: String? = null,

	@field:SerializedName("original_title")
	val originalTitle: String? = null,

	@field:SerializedName("overview")
	val overview: String? = null,

	@field:SerializedName("popularity")
	val popularity: Any? = null,

	@field:SerializedName("poster_path")
	val posterPath: Any? = null,

	@field:SerializedName("release_date")
	val releaseDate: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("video")
	val video: Boolean? = null,

	@field:SerializedName("vote_average")
	val voteAverage: Double? = null,

	@field:SerializedName("vote_count")
	val voteCount: Int? = null
)