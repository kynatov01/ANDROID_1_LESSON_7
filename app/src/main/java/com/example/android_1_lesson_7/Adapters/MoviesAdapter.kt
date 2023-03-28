package com.example.android_1_lesson_7.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_1_lesson_7.ui.Interface.OnItemClickForMovies
import com.example.android_1_lesson_7.data.MoviesModel
import com.example.android_1_lesson_7.databinding.ItemNameBinding

class MoviesAdapter (private val onItemClick: OnItemClickForMovies,
                     private var listModel: MutableList<MoviesModel>) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {


    inner class MoviesViewHolder(private val binding: ItemNameBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(moviesModel: MoviesModel) {
            binding.imageRecyclerview.let {
                Glide.with(it).load(moviesModel.imageMovies).into(binding.imageRecyclerview)}
            binding.textviewRecyclerview.text = moviesModel.nameMovies
            itemView.setOnClickListener(View.OnClickListener {
                onItemClick.onShortClickForMovies(moviesModel)
            })
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNameBinding.inflate(inflater, parent, false)
        return MoviesViewHolder(binding)    }

    override fun getItemCount(): Int = listModel.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.onBind(listModel[position])    }
}
