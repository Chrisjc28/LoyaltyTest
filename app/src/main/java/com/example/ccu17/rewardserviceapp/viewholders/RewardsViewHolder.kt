package com.example.ccu17.rewardserviceapp.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.ccu17.rewardserviceapp.R
import kotlinx.android.synthetic.main.list_item_feed.view.*

class RewardsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var rewards: TextView = itemView.findViewById(R.id.list_item_rewards)

    fun onBind(dataset: List<String>, position: Int) {
            rewards.text = dataset[position]
        }
}

