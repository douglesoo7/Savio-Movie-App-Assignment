package dougles.project.saviomovieappassignment.ui.activitiesandfragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import dougles.project.saviomovieappassignment.R
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val originalTitle = intent.getStringExtra("originalTitle")
        val releaseDate = intent.getStringExtra("releaseDate")
        val overview = intent.getStringExtra("overview")
        val voteAverage = intent.getStringExtra("voteAverage")
        val voteCount = intent.getStringExtra("voteCount")
        val posterPath = intent.getStringExtra("posterPath")

        tvTitle.text = originalTitle
        tvSynopsis.text = overview
        tvRating.text = voteAverage
        Glide.with(this).load("https://image.tmdb.org/t/p/w500/${posterPath}").into(ivPoster)
        tvDate.text = releaseDate
        tvReview.text = voteCount

        ivBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }


    }
}