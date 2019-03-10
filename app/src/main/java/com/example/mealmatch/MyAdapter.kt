package com.example.mealmatch

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.item_match.view.*

class MyAdapter(val items : ArrayList<Person>, val context: Context) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    var onItemClick: ((String, String) -> Unit)? = null

    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_match, parent, false))
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = items.get(position).name
        holder.location.text = items.get(position).location!!.getTitle()
        holder.time.text = items.get(position).time.toString()
    }

    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val name = view.matchname
        val location = view.matchlocation
        val time = view.matchtime

        init {
            view.setOnClickListener {
                onItemClick?.invoke(items[adapterPosition].name, items[adapterPosition].emailOrPhone)
            }
        }
    }

}