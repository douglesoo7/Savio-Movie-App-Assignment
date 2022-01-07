package dougles.project.saviomovieappassignment.ui.activitiesandfragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import dougles.project.saviomovieappassignment.R
import dougles.project.saviomovieappassignment.data.model.ResponseDTO
import dougles.project.saviomovieappassignment.repository.MoviesRepository
import dougles.project.saviomovieappassignment.ui.adapters.ComingSoonSliderAdapter
import dougles.project.saviomovieappassignment.ui.utility.SliderItem
import dougles.project.saviomovieappassignment.ui.viewmodel.MoviesViewModel
import dougles.project.saviomovieappassignment.ui.viewmodel.MoviesViewModelFactory
import kotlinx.android.synthetic.main.fragment_home.*
import kotlin.math.abs

class HomeFragment : Fragment() {

    lateinit var viewModel: MoviesViewModel
    lateinit var repository: MoviesRepository
    lateinit var navController: NavController
    lateinit var comingSoonSliderAdapter: ComingSoonSliderAdapter
    val sliderItemsList = ArrayList<SliderItem>()
    var moviesResponse: ResponseDTO? = null

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
        setData()

        setSlider()


    }

    private fun setData() {


        repository = MoviesRepository(requireContext())

        val moviesViewModelFactory = MoviesViewModelFactory(repository)
        viewModel = ViewModelProvider(this, moviesViewModelFactory).get(MoviesViewModel::class.java)

        viewModel.getResponseFromApi()
        viewModel.response.observe(requireActivity(), Observer { it ->
            it.comingSoon?.forEach {
                it?.let {
                    val sliderItem = SliderItem(it.posterurl!!)
                    sliderItemsList.add(sliderItem)
                }
            }
            moviesResponse = it
            setComingSoonRecyclerView()
            //Log.d("Sachin", it.comingSoon.toString())
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

    //for setting recyclerview
    private fun setComingSoonRecyclerView() {
        comingSoonSliderAdapter =
            ComingSoonSliderAdapter(requireActivity(), sliderItemsList, viewPagerSliderComingSoon)
        viewPagerSliderComingSoon.adapter = comingSoonSliderAdapter
    }

}