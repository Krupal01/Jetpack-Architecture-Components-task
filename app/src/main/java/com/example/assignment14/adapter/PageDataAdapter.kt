package com.example.assignment14.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment14.R
import com.example.assignment14.databinding.RowItemHitsBinding
import com.example.assignment14.model.HitsItem

class PageDataAdapter : RecyclerView.Adapter<PageDataAdapter.HitsViewHolder>() {
    private var hitsList = ArrayList<HitsItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(hits : ArrayList<HitsItem>){
        this.hitsList = hits
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HitsViewHolder {
        var binding = RowItemHitsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HitsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HitsViewHolder, position: Int) {
        holder.bind(hitsList[position])
    }

    override fun getItemCount(): Int {
        return hitsList.size
    }

    class HitsViewHolder(private var binding : RowItemHitsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hitsItem: HitsItem){
            binding.hitsItem = hitsItem
        }
    }

}