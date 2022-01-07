package dougles.project.saviomovieappassignment.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseDTO(

	@field:SerializedName("coming_soon")
	val comingSoon: List<ComingSoonDTO?>? = null,

	@field:SerializedName("now_showing")
	val nowShowing: List<NowShowingDTO?>? = null
)