package dougles.project.saviomovieappassignment.ui.activitiesandfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import dougles.project.saviomovieappassignment.R
import dougles.project.saviomovieappassignment.repository.MoviesRepository
import dougles.project.saviomovieappassignment.ui.viewmodel.MoviesViewModel
import dougles.project.saviomovieappassignment.ui.viewmodel.MoviesViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MoviesViewModel
    lateinit var repository: MoviesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        repository = MoviesRepository(this)
        val moviesViewModelFactory = MoviesViewModelFactory(repository)
        viewModel = ViewModelProvider(this, moviesViewModelFactory).get(MoviesViewModel::class.java)

        viewModel.getMoviesFromApi()
        viewModel.movie.observe(this, Observer {
            Toast.makeText(this, ""+it.toString(), Toast.LENGTH_SHORT).show()
        })
    }
}