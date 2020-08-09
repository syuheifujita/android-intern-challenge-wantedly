package com.syuheifujita.android_intern_challenge_wantedly

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.syuheifujita.android_intern_challenge_wantedly.model.ItemModel
import kotlinx.android.synthetic.main.item_view.view.*

class ItemAdapter(private val context: Context, private val itemList: MutableList<ItemModel>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ItemViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        Picasso.get().load(itemList[position].imageUrl).into(holder.ivImageUrl)
        holder.tvLookingFor.text = itemList[position].lookingFor
        holder.tvTitle.text = itemList[position].title
        Picasso.get().load(itemList[position].imageUrl).into(holder.ivAvatar)
        holder.tvCompanyName.text = itemList[position].companyName

//        val currentItem = itemList[position]
//        holder.ivImageUrl.setImageResource(currentItem.imageUrl)
//        holder.tvTitle.text = currentItem.title
    }

    override fun getItemCount(): Int = itemList.size

    inner class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        var ivImageUrl: ImageView = view.iv_image_url
        var tvLookingFor: TextView = view.tv_looking_for
        var tvTitle: TextView = view.tv_title
        var ivAvatar: ImageView = view.iv_avatar
        var tvCompanyName: TextView = view.tv_company_name

        init {
            ivImageUrl = itemView.iv_image_url
            tvLookingFor = itemView.tv_looking_for
            tvTitle = itemView.tv_title
            ivAvatar = itemView.iv_avatar
            tvCompanyName = itemView.tv_company_name
        }
    }
}
