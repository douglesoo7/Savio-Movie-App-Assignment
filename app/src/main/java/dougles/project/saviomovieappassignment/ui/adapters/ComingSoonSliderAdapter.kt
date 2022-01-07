package dougles.project.saviomovieappassignment.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import dougles.project.saviomovieappassignment.R
import dougles.project.saviomovieappassignment.ui.utility.SliderItem

class ComingSoonSliderAdapter(
    private val context: Context,
    private val sliderItems: ArrayList<SliderItem>, val viewPager2: ViewPager2
) : RecyclerView.Adapter<ComingSoonSliderViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComingSoonSliderViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.coming_soon_item_layout, parent, false)
        return ComingSoonSliderViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComingSoonSliderViewHolder, position: Int) {
        holder.setImage(sliderItems[position]);
//        if (position == sliderItems.size - 2) {
//            sliderItems.addAll(sliderItems)
//        }
    }

    override fun getItemCount(): Int {
        return sliderItems.size
    }
}