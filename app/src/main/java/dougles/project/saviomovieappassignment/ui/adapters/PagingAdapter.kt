package dougles.project.saviomovieappassignment.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import dougles.project.saviomovieappassignment.R
import dougles.project.saviomovieappassignment.data.model.MoviesApiResults
import dougles.project.saviomovieappassignment.ui.utility.ItemClickListener

class PagingAdapter(private val itemClickListener: ItemClickListener) :
    PagingDataAdapter<MoviesApiResults, NowShowingViewHolder>(diff) {
    companion object {
        val diff = object : DiffUtil.ItemCallback<MoviesApiResults>() {
            override fun areItemsTheSame(
                oldItem: MoviesApiResults,
                newItem: MoviesApiResults
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: MoviesApiResults,
                newItem: MoviesApiResults
            ): Boolean {
                return oldItem.id == newItem.id && oldItem.title == newItem.title
            }

        }
    }

    override fun onBindViewHolder(holder: NowShowingViewHolder, position: Int) {
        val res = getItem(position)
        holder.setNowShowingMoviesData(res!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowShowingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.now_showing_item_layout, parent, false)
        return NowShowingViewHolder(view, itemClickListener)
    }

}