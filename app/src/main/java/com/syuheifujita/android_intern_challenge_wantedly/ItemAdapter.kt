package com.syuheifujita.android_intern_challenge_wantedly

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.syuheifujita.android_intern_challenge_wantedly.model.ItemModel
import kotlinx.android.synthetic.main.item_view.view.*

class ItemAdapter(private val itemList: List<ItemModel>): RecyclerView.Adapter<ItemAdapter.ViewHolder>(){

    val titles = listOf("First title", "Second", "3rd", "More")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(itemView)

//        val layoutInflater = LayoutInflater.from(parent?.context)
//        val cell = layoutInflater.inflate(R.layout.item_view, parent, false)
//        return ViewHolder(cell)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]

        holder.imageView.setImageResource(currentItem.ImageUrl)
        holder.textTitle.text = currentItem.title

//        val titles = titles.get(position)
//        holder.view?.tv_title?.text = titles
    }

    override fun getItemCount(): Int = itemList.size

    inner class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.iv_eyecatch
        val textTitle: TextView = view.tv_title
    }
}
