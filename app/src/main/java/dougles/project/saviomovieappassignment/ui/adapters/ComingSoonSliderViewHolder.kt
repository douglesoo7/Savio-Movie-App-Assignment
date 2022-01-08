package dougles.project.saviomovieappassignment.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dougles.project.saviomovieappassignment.ui.utility.SliderItem
import kotlinx.android.synthetic.main.coming_soon_item_layout.view.*

class ComingSoonSliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setImage(sliderItem: SliderItem) {
        itemView.apply {
            Glide.with(ivComingSoonMoviePoster).load("https://image.tmdb.org/t/p/w500/"+sliderItem.imageUrl).into(ivComingSoonMoviePoster)
        }
    }

}
