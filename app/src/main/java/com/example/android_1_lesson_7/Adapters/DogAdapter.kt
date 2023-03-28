package com.example.android_1_lesson_7.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_1_lesson_7.ui.Interface.OnItemClick
import com.example.android_1_lesson_7.data.DogModel
import com.example.android_1_lesson_7.databinding.ItemNameBinding

class DogAdapter(private val onItemClick: OnItemClick,
                 private var listModel: MutableList<DogModel>) : RecyclerView.Adapter<DogAdapter.DogViewHolder>() {


    inner class DogViewHolder(private val binding: ItemNameBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(dogModel: DogModel) {
            binding.imageRecyclerview.let {
                Glide.with(it).load(dogModel.imageDog).into(binding.imageRecyclerview)
            }
            binding.textviewRecyclerview.text = dogModel.nameDog
            itemView.setOnClickListener(View.OnClickListener {
                onItemClick.onShortClickForDog(dogModel)
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNameBinding.inflate(inflater, parent, false)
        return DogViewHolder(binding)    }

    override fun getItemCount(): Int = listModel.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.onBind(listModel[position])    }
}