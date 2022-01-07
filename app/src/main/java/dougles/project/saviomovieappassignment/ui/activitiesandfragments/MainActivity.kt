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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}