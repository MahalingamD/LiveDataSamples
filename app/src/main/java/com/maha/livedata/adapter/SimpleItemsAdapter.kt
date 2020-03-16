package com.maha.livedata.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.maha.livedata.R
import com.maha.livedata.databinding.SimpleItemViewBinding

class SimpleItemsAdapter : RecyclerView.Adapter<SimpleItemsAdapter.ViewHolder>() {

    private var mItems: List<String> = arrayListOf()

    private val loading = 1
    private val item = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == loading) {
            ItemViewHolder(parent)
        } else {
            ItemViewHolder(parent)
        }
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (mItems[position] == "loading") loading else item
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ItemViewHolder && mItems.size > position) {
            holder.bind(mItems[position])
        }
    }


    abstract class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class ItemViewHolder(
        private val parent: ViewGroup,
        private val binding: SimpleItemViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.simple_item_view,
            parent,
            false
        )
    ) : ViewHolder(binding.root) {

        fun bind(item: String) {
            binding.item = item
        }
    }


    fun update(items: List<String>) {
        mItems = items
        notifyDataSetChanged()
    }

}