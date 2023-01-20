package com.example.rickandmortyapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.data.model.RickAndMorty
import com.example.rickandmortyapp.databinding.ItemListBinding



class RickAndMortyAdapter (private val onClickListener: OnClickListener): ListAdapter<RickAndMorty, RickAndMortyAdapter.RickAndMortyViewHolder>(
    DiffCallback
) {
    class RickAndMortyViewHolder(private var binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(rickAndMorty: RickAndMorty) {
            binding.property = rickAndMorty
            binding.executePendingBindings()
        }

    }

    override fun submitList(list: MutableList<RickAndMorty>?) {
        super.submitList(list?.let { ArrayList(it) })
    }

    companion object DiffCallback: DiffUtil.ItemCallback<RickAndMorty>() {
        override fun areItemsTheSame(oldItem: RickAndMorty, newItem: RickAndMorty): Boolean {
            return  oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: RickAndMorty, newItem: RickAndMorty): Boolean {
            return  oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RickAndMortyViewHolder {
        return RickAndMortyViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RickAndMortyViewHolder, position: Int) {
        val rickAndMorty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(rickAndMorty)
        }
        holder.bind(rickAndMorty)
    }

    class OnClickListener (val clickListener: (rickAndMorty: RickAndMorty) -> Unit) {
        fun onClick(rickAndMorty: RickAndMorty) = clickListener(rickAndMorty)
    }

}