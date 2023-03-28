package com.example.android_1_lesson_7.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_1_lesson_7.ui.Interface.OnItemClickForCat
import com.example.android_1_lesson_7.data.CatModel
import com.example.android_1_lesson_7.databinding.ItemNameBinding

class CatAdapter(private val onItemClick: OnItemClickForCat,
                 private var listModel: MutableList<CatModel>) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    inner class CatViewHolder(private val binding: ItemNameBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(catModel: CatModel) {
            Glide.with(binding.imageRecyclerview).load(catModel.imageCat).into(binding.imageRecyclerview)
            binding.textviewRecyclerview.text = catModel.nameCat
            itemView.setOnClickListener {
                onItemClick.onShortClickForCat(catModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNameBinding.inflate(inflater, parent, false)
        return CatViewHolder(binding)
    }

    override fun getItemCount(): Int = listModel.size

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.onBind(listModel[position])
    }
}