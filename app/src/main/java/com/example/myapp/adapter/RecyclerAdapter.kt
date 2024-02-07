package com.example.myapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R
import com.example.myapp.fragments.ProductFragment
import com.example.myapp.model.DataModelItem

class RecyclerAdapter(val list:ArrayList<DataModelItem>, val context: ProductFragment): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val albumId:TextView = itemView.findViewById(R.id.album_id)
        val textId:TextView = itemView.findViewById(R.id.text_id)
        val titleId: TextView = itemView.findViewById(R.id.title_id)
        val thumbNail:TextView = itemView.findViewById(R.id.thumbnail_view)
        val urlId: TextView = itemView.findViewById(R.id.url_view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_product,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem=list[position]

        holder.apply {
            albumId.text = currentItem.albumId.toString()
            textId.text = currentItem.id.toString()
            titleId.text = currentItem.title
            thumbNail.text = currentItem.thumbnailUrl
            urlId.text = currentItem.url
        }
    }
}