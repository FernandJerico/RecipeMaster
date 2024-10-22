package com.ferico.recipemaster.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ferico.recipemaster.R
import com.ferico.recipemaster.data.Notification

class NotificationAdapter(private val notificationList: List<Notification>, private val onItemClick: (Notification) -> Unit) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {
    class NotificationViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val title: TextView = v.findViewById(R.id.tv_notification_title)
        val body: TextView = v.findViewById(R.id.tv_notification_body)
        val clicked: CardView = v.findViewById(R.id.cv_notification)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notification, parent, false)
        return NotificationViewHolder(view)
    }

    override fun getItemCount(): Int = notificationList.size

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notification = notificationList[position]
        holder.title.text = notification.title
        holder.body.text = notification.body

        // Set click listener untuk item
        holder.itemView.setOnClickListener {
            onItemClick(notification)
        }
    }
}