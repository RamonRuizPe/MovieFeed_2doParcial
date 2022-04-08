package com.lharo.exam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AppAd (context: Context, Entry: ArrayList<MovieModel>): RecyclerView.Adapter<AppAd.ViewHolder>(){
    private var localContext: Context? = null
    private var localEntry: ArrayList<MovieModel>? = null

    init {
        localContext = context
        localEntry = Entry
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppAd.ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(localContext)
        val view: View = layoutInflater.inflate(R.layout.movie_row, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentFeedEntry: MovieModel = localEntry!![position]
        holder.textTitle.text = currentFeedEntry.title
        holder.textLanguage.text = currentFeedEntry.language
        holder.textYear.text = currentFeedEntry.year
        holder.textDirector.text = currentFeedEntry.director
    }

    override fun getItemCount(): Int {
        return localEntry?.size?:0
    }

    class ViewHolder(v: View): RecyclerView.ViewHolder(v){
        val textTitle: TextView = v.findViewById(R.id.tvMovie)
        val textYear: TextView = v.findViewById(R.id.tvYear)
        val textLanguage: TextView = v.findViewById(R.id.tvLan)
        val textDirector: TextView = v.findViewById(R.id.tvDirector)
    }

}