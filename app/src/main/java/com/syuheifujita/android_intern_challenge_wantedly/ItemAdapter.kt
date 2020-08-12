package com.syuheifujita.android_intern_challenge_wantedly

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.syuheifujita.android_intern_challenge_wantedly.databinding.ItemViewBinding
import com.syuheifujita.android_intern_challenge_wantedly.model.ItemResponse

class ItemAdapter(private val context: Context, private val itemList: ItemResponse): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ItemViewHolder {
        val binding: ItemViewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_view, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList.data[position]

        Picasso.get().load(currentItem.image.original).into(holder.ivImageUrl)
        holder.tvLookingFor.text = currentItem.looking_for
        holder.tvTitle.text = currentItem.title
        Picasso.get().load(currentItem.company.avatar.original).into(holder.ivAvatar)
        holder.tvCompanyName.text = currentItem.company.name

        holder.binding.llRvItem.setOnClickListener {
            val intent = Intent(context, RecyclerViewItemDetailActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = itemList.data.size

    class ItemViewHolder(val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root) {
        var ivImageUrl: ImageView = binding.ivImageUrl
        var tvLookingFor: TextView = binding.tvLookingFor
        var tvTitle: TextView = binding.tvTitle
        var ivAvatar: ImageView = binding.ivAvatar
        var tvCompanyName: TextView = binding.tvCompanyName

        init {
            val position: Int = adapterPosition
        }
    }
}
