package dougles.project.saviomovieappassignment.ui.adapters

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dougles.project.saviomovieappassignment.R
import dougles.project.saviomovieappassignment.data.model.MoviesApiResults
import dougles.project.saviomovieappassignment.ui.utility.ItemClickListener
import dougles.project.saviomovieappassignment.ui.utility.SliderItem
import kotlinx.android.synthetic.main.coming_soon_item_layout.view.*
import kotlinx.android.synthetic.main.now_showing_item_layout.view.*
import java.lang.Exception


/*class NowShowingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setNowShowingMoviesData(movie: MoviesApiResults) {

        val imageUrl = "https://image.tmdb.org/t/p/w500/${movie.posterPath!!}"
        try {
            itemView.apply {
                Glide.with(ivNowShowing).load(imageUrl).into(ivNowShowing)
            }

        } catch (e: Exception) {
            Toast.makeText(itemView.context, "" + e.message, Toast.LENGTH_SHORT).show()
        }
    }
}*/

class NowShowingViewHolder(itemView: View, val itemClickListener: ItemClickListener) :
    RecyclerView.ViewHolder(itemView) {

    private val ivPoster: ImageView = itemView.findViewById(R.id.ivNowShowing)

    fun setNowShowingMoviesData(movie: MoviesApiResults) {

        val imageUrl = "https://image.tmdb.org/t/p/w500/${movie.posterPath}"
        try {
            itemView.apply {
                Glide.with(ivPoster).load(imageUrl.toString()).into(ivPoster)
                this.setOnClickListener {
                    itemClickListener.itemClickListener(movie)
                }
            }

        } catch (e: Exception) {
            Toast.makeText(itemView.context, "" + e.message, Toast.LENGTH_SHORT).show()
        }
    }
}
