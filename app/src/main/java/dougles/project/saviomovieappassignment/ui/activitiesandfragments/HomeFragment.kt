package dougles.project.saviomovieappassignment.ui.activitiesandfragments

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import dougles.project.saviomovieappassignment.R
import dougles.project.saviomovieappassignment.data.model.MoviesApiResults
import dougles.project.saviomovieappassignment.repository.MoviesRepository
import dougles.project.saviomovieappassignment.ui.adapters.ComingSoonSliderAdapter
import dougles.project.saviomovieappassignment.ui.adapters.PagingAdapter
import dougles.project.saviomovieappassignment.ui.utility.ItemClickListener
import dougles.project.saviomovieappassignment.ui.utility.SliderItem
import dougles.project.saviomovieappassignment.ui.viewmodel.MoviesViewModel
import dougles.project.saviomovieappassignment.ui.viewmodel.MoviesViewModelFactory
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.abs

class HomeFragment : Fragment(), ItemClickListener {

    lateinit var viewModel: MoviesViewModel
    lateinit var repository: MoviesRepository
    lateinit var navController: NavController
    lateinit var comingSoonSliderAdapter: ComingSoonSliderAdapter
    private val sliderItemsList = ArrayList<SliderItem>()
    lateinit var pagingAdapter: PagingAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        repository = MoviesRepository()
        val moviesViewModelFactory = MoviesViewModelFactory(repository)
        viewModel = ViewModelProvider(this, moviesViewModelFactory).get(MoviesViewModel::class.java)
        setMoviesData()
        setSlider()
        setDataFromApiUsingPagination()
        setNowShowingRecyclerView()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            nestedScrollView.setOnScrollChangeListener(object : View.OnScrollChangeListener {
                override fun onScrollChange(p0: View?, p1: Int, p2: Int, p3: Int, p4: Int) {

                    if (p2 >= 500) {
                        tvHeader.text = "Now Showing"
                    } else {
                        tvHeader.text = "Movies"
                    }
                }

            })
        }
    }

    //for setting coming soon data
    private fun setMoviesData() {

        viewModel.getNowShowingResponseFromMoviesApi()
        viewModel.responseNowShowing.observe(requireActivity(), Observer {

            it.results?.forEach {
                it?.let {
                    val sliderItem = SliderItem(it.posterPath.toString()!!)
                    sliderItemsList.add(sliderItem)
                }
            }
            setComingSoonRecyclerView()
        })
    }

    //For the sliding feature
    private fun setSlider() {
        val compositePageTransformer = CompositePageTransformer()
        with(compositePageTransformer) {
            addTransformer(MarginPageTransformer(40))
            addTransformer { page, position ->
                val r: Float = 1 - abs(position)
                page.scaleY = .85f + r * 0.15f
            }
        }
        viewPagerSliderComingSoon.apply {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            setPageTransformer(compositePageTransformer)

        }
    }

    //for setting Coming Soon Recyclerview
    private fun setComingSoonRecyclerView() {
        comingSoonSliderAdapter =
            ComingSoonSliderAdapter(requireActivity(), sliderItemsList, viewPagerSliderComingSoon)
        viewPagerSliderComingSoon.adapter = comingSoonSliderAdapter
    }

    //for setting now showing adapter
    private fun setNowShowingRecyclerView() {

        pagingAdapter = PagingAdapter(this)
        recyclerViewNowShowing.adapter = pagingAdapter
        recyclerViewNowShowing.layoutManager = GridLayoutManager(requireActivity(), 3)
    }

    //for setting now showing data using pagination
    private fun setDataFromApiUsingPagination() {
        viewModel.paging().observe(viewLifecycleOwner, Observer {
            CoroutineScope(Dispatchers.Main).launch {
                pagingAdapter.submitData(it)

            }
        })
    }

    override fun itemClickListener(moviesApiResults: MoviesApiResults) {
        val intent = Intent(requireContext(), MovieDetailsActivity::class.java)

        intent.apply {
            putExtra("originalTitle", moviesApiResults.originalTitle)
            putExtra("language", moviesApiResults.originalLanguage)
            putExtra("releaseDate", moviesApiResults.releaseDate)
            putExtra("overview", moviesApiResults.overview)
            putExtra("voteAverage", moviesApiResults.voteAverage.toString())
            putExtra("voteCount", moviesApiResults.voteCount.toString())
            putExtra("title", moviesApiResults.title)
            putExtra("genreIds", moviesApiResults.genreIds.toString())
            putExtra("posterPath", moviesApiResults.posterPath.toString())

        }
        startActivity(intent)
    }


}