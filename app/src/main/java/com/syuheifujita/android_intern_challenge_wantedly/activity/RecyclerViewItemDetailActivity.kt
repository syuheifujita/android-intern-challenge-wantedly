package com.syuheifujita.android_intern_challenge_wantedly.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.squareup.picasso.Picasso
import com.syuheifujita.android_intern_challenge_wantedly.R
import com.syuheifujita.android_intern_challenge_wantedly.databinding.ActivityRecyclerViewItemDetailBinding

class RecyclerViewItemDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewItemDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_recycler_view_item_detail
        )

        val imageUrl = intent.getStringExtra("image")
        val lookingFor = intent.getStringExtra("lookingFor")
        val title = intent.getStringExtra("title")
        val avatar = intent.getStringExtra("avatar")
        val companyName = intent.getStringExtra("companyName")

        setImage(imageUrl, lookingFor, title, avatar, companyName)
    }

    private fun setImage(imageUrl: String, lookingFor: String, title: String, avatar: String, companyName: String) {
        Picasso.get().load(imageUrl).into(binding.ivRvItemImageUrl)
        binding.tvRvItemLookingFor.text = lookingFor
        binding.tvRvItemTitle.text = title
        Picasso.get().load(avatar).into(binding.ivRvItemAvatar)
        binding.tvRvItemCompanyName.text = companyName
    }
}
