package dougles.project.saviomovieappassignment.data.model

import java.io.Serializable

data class ComingSoonDTO(
	val id: String? = null,
	val title: String? = null,
	val year: String? = null,
	val contentRating: String? = null,
	val duration: String? = null,
	val releaseDate: String? = null,
	val averageRating: Int? = null,
	val originalTitle: String? = null,
	val storyline: String? = null,
	val imdbRating: String? = null,
	val posterurl: String? = null,
	val videoUrl: String? = null
)