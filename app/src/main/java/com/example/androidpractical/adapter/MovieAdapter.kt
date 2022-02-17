package com.example.androidpractical.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractical.Models.MovieModelClass
import com.example.androidpractical.R

class MovieAdapter(private val modelList: List<MovieModelClass>) :
    RecyclerView.Adapter<MovieAdapter.AdapterVH>() {
    class AdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvMovieName: TextView = itemView.findViewById(R.id.tvName)
        var movieImageView: ImageView = itemView.findViewById(R.id.imageView)
        var tvMovieFirstAppearance: TextView = itemView.findViewById(R.id.tvFirstAppearance)
        var tvMovieTeam: TextView = itemView.findViewById(R.id.tvTeam)
        var tvMovieCreatedBy: TextView = itemView.findViewById(R.id.tvCreatedBy)
        var tvPublisher: TextView = itemView.findViewById(R.id.tvPublisher)
        var tvMovieRealName: TextView = itemView.findViewById(R.id.tvRealName)
        var tvMovieBio: TextView = itemView.findViewById(R.id.tvBio)
        var linearLayout: LinearLayout = itemView.findViewById(R.id.linearLayout)
        var expendableLayout: ConstraintLayout = itemView.findViewById(R.id.expandable_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterVH {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.single_item_expandableview, parent, false)
        return AdapterVH(view)
    }

    override fun onBindViewHolder(holder: AdapterVH, position: Int) {
        val model: MovieModelClass = modelList[position]
        holder.apply {
            tvMovieName.text = model.movieName
            movieImageView.setImageResource(model.movieImage)
            tvMovieRealName.text = model.movieRealName
            tvMovieFirstAppearance.text = model.movieFirstAppearance
            tvMovieTeam.text = model.movieTeam
            tvMovieCreatedBy.text = model.movieCreatedBy
            tvPublisher.text = model.moviePublisher
            tvMovieBio.text = model.movieBio
        }

        val isExpandable: Boolean = modelList[position].expandable
        holder.expendableLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE

        holder.linearLayout.setOnClickListener {
            val version = modelList[position]
            version.expandable = !model.expandable
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return modelList.size
    }
}