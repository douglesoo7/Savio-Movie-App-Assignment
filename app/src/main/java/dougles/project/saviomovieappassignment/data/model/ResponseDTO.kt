package dougles.project.saviomovieappassignment.data.model

import java.io.Serializable

data class ResponseDTO(
	val comingSoon: List<ComingSoonDTO?>? = null,
	val nowShowing: List<NowShowingDTO?>? = null
)