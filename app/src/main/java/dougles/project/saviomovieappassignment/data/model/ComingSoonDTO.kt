package dougles.project.saviomovieappassignment.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ComingSoonDTO(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("year")
	val year: String? = null,

	@field:SerializedName("contentRating")
	val contentRating: String? = null,

	@field:SerializedName("duration")
	val duration: String? = null,

	@field:SerializedName("releaseDate")
	val releaseDate: String? = null,

	@field:SerializedName("averageRating")
	val averageRating: Int? = null,

	@field:SerializedName("originalTitle")
	val originalTitle: String? = null,

	@field:SerializedName("storyline")
	val storyline: String? = null,

	@field:SerializedName("imdbRating")
	val imdbRating: String? = null,

	@field:SerializedName("posterurl")
	val posterurl: String? = null,

	@field:SerializedName("video_url")
	val videoUrl: String? = null
)