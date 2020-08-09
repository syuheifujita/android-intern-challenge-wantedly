package com.syuheifujita.android_intern_challenge_wantedly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.syuheifujita.android_intern_challenge_wantedly.model.ItemModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemList = generateDummyList(6)

        recyclerview.adapter = ItemAdapter(itemList)
        recyclerview.layoutManager = LinearLayoutManager(this)
//        recyclerview.layoutManager = GridLayoutManager(this, 3)
    }

    private fun generateDummyList(size: Int): List<ItemModel> {
        val list = ArrayList<ItemModel>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_launcher_background
                1 -> R.drawable.ic_launcher_background
                else -> R.drawable.ic_launcher_background
            }
            val item = ItemModel(drawable, "Item $i")
            list += item
        }
        return list
    }
}
