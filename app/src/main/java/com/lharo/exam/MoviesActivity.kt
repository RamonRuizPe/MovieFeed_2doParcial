package com.lharo.exam

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates

val movies = ArrayList<MovieModel>()
class MoviesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        val recyclerView: RecyclerView = findViewById(R.id.movie_recycler)

        val titles: Array<String> = resources.getStringArray(R.array.title)
        val years: Array<String> = resources.getStringArray(R.array.year)
        val directors: Array<String> = resources.getStringArray(R.array.director)
        val genres: Array<String> = resources.getStringArray(R.array.genre)
        val languages: Array<String> = resources.getStringArray(R.array.language)
        val metascores: Array<String> = resources.getStringArray(R.array.metascore)
        val imdbRatings: Array<String> = resources.getStringArray(R.array.imdbRating)
        val imdbVotes: Array<String> = resources.getStringArray(R.array.imdbVotes)

        for((i, element) in titles.withIndex()){
            val movie = MovieModel()
            movie.title = element
            movie.year = years[i]
            movie.director = directors[i]
            movie.genre = genres[i]
            movie.language = languages[i]
            movie.metascore = metascores[i]
            movie.imdbRating = imdbRatings[i]
            movie.imdbVotes = imdbVotes[i]
            movies.add(movie)
        }

        val layoutgen = LayoutGen(this, recyclerView)
        layoutgen.adapterLayout()
    }

    companion object{
        private class LayoutGen(context:Context, recyclerView: RecyclerView){
            var localContext: Context by Delegates.notNull()
            var localRecyclerView: RecyclerView by Delegates.notNull()

            init{
                localContext = context
                localRecyclerView = recyclerView
            }

            fun adapterLayout(){
                val adapter: AppAd = AppAd(localContext, movies)
                localRecyclerView.adapter = adapter
                localRecyclerView.layoutManager =LinearLayoutManager(localContext)
            }

        }
    }
}