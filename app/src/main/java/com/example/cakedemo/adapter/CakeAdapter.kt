package com.example.cakedemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cakedemo.databinding.RowCakesBinding
import com.example.cakedemo.model.Cake_ItemsItem

class CakeAdapter : ListAdapter<Cake_ItemsItem, CakeAdapter.MyViewHolder>(SampleItemDiffCallback()) {

    class MyViewHolder (val itemBinding: RowCakesBinding): RecyclerView.ViewHolder(itemBinding.root) {



    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
        //view binding
        val binding = RowCakesBinding.inflate(view,parent,false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val Cake_ItemsItemList = getItem(position)
        holder.itemBinding.CakeNamettxt.text = Cake_ItemsItemList.title.toString()
        Glide.with(holder.itemView.context)
            .load(Cake_ItemsItemList.image)
            .into(holder.itemBinding.cakeimageView)
    }

}


class SampleItemDiffCallback : DiffUtil.ItemCallback<Cake_ItemsItem>() {
    override fun areItemsTheSame(oldItem: Cake_ItemsItem, newItem: Cake_ItemsItem): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Cake_ItemsItem, newItem: Cake_ItemsItem): Boolean =
        oldItem == newItem

}


