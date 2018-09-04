package com.example.ccu17.rewardserviceapp.adpaters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ccu17.rewardserviceapp.R
import com.example.ccu17.rewardserviceapp.viewholders.RewardsViewHolder

class MainAdapter(private val dataset: List<String>) : RecyclerView.Adapter<RewardsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_feed, parent, false)
        return RewardsViewHolder(view)
    }
    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: RewardsViewHolder, position: Int) {
        holder.onBind(dataset, position)
    }
}