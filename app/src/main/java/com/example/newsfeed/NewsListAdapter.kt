package com.example.newsfeed

import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsListAdapter(private val items:ArrayList<String>, private val listener: NewsItemClicked): RecyclerView.Adapter<NewsViewHolders>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolders {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        val viewHolder=NewsViewHolders(view)
        view.setOnClickListener{

            listener.OnitemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder


    }

    override fun onBindViewHolder(holder: NewsViewHolders, position: Int) {
        val currentItems=items[position]
        holder.titleView.text=currentItems

    }

    override fun getItemCount(): Int {
        return items.size
    }

}


class  NewsViewHolders(itemView: View):RecyclerView.ViewHolder(itemView){
    val titleView:TextView=itemView.findViewById(R.id.title);
}

interface NewsItemClicked{
        fun OnitemClicked(item:String ){

        }
}