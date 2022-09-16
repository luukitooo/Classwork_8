package com.example.classwork_8.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.classwork_8.R
import com.example.classwork_8.databinding.ItemShmotkaBinding
import com.example.classwork_8.domain.model.Outfit

class OutfitAdapter : ListAdapter<Outfit, OutfitAdapter.OutfitViewHolder>(ShmotkaItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = OutfitViewHolder(
        ItemShmotkaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: OutfitViewHolder, position: Int) {
        holder.bind()
    }

    inner class OutfitViewHolder(private val binding: ItemShmotkaBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val outfit = getItem(adapterPosition)
            binding.apply {
                tvTitle.text = outfit.title
                tvPrice.text = outfit.price
                Glide.with(binding.root)
                    .load(outfit.cover)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ivShmotka)
                if (outfit.liked == true) {
                    btnSave.setImageResource(R.drawable.ic_favorite)
                } else {
                    btnSave.setImageResource(R.drawable.ic_favorite_outline)
                }
            }
        }
    }

    private object ShmotkaItemCallback : DiffUtil.ItemCallback<Outfit>() {
        override fun areItemsTheSame(oldItem: Outfit, newItem: Outfit): Boolean {
            return oldItem.cover == newItem.cover
        }

        override fun areContentsTheSame(oldItem: Outfit, newItem: Outfit): Boolean {
            return oldItem == newItem
        }
    }

}