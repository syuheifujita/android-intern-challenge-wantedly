package com.syuheifujita.android_intern_challenge_wantedly

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.syuheifujita.android_intern_challenge_wantedly.model.ItemResponse
import kotlinx.android.synthetic.main.item_view.view.*

class ItemAdapter(private val itemList: ItemResponse): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ItemViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
//        val binding: ItemViewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_view, parent, false)
        return ItemViewHolder(item)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList.data[position]

        holder.tvTitle.text = currentItem.title

        Picasso.get().load(currentItem.image.original).into(holder.ivImageUrl)
        holder.tvLookingFor.text = currentItem.looking_for
        Picasso.get().load(currentItem.company.avatar.original).into(holder.ivAvatar)
        holder.tvCompanyName.text = currentItem.company.name
    }

    override fun getItemCount(): Int = itemList.data.size

    class ItemViewHolder(
        val view: View
//        val binding: ItemViewBinding
    ): RecyclerView.ViewHolder(
        view
//        binding.root
    ) {
        var ivImageUrl: ImageView = view.iv_image_url
        var tvLookingFor: TextView = view.tv_looking_for
        var tvTitle: TextView = view.tv_title
        var ivAvatar: ImageView = view.iv_avatar
        var tvCompanyName: TextView = view.tv_company_name
    }
}
