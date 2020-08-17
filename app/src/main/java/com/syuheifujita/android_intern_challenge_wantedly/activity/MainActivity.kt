package com.syuheifujita.android_intern_challenge_wantedly.activity

import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.syuheifujita.android_intern_challenge_wantedly.Constant
import com.syuheifujita.android_intern_challenge_wantedly.ItemAdapter
import com.syuheifujita.android_intern_challenge_wantedly.R
import com.syuheifujita.android_intern_challenge_wantedly.`interface`.ItemService
import com.syuheifujita.android_intern_challenge_wantedly.databinding.ActivityMainBinding
import com.syuheifujita.android_intern_challenge_wantedly.model.Data
import com.syuheifujita.android_intern_challenge_wantedly.model.ItemResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var itemList = mutableListOf<Data>()
    private var filteredItemList = mutableListOf<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        getClient("java", 0)

        binding.svRvItem.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filteredItemList.clear()
                for (i in itemList.indices) {
                    if (itemList[i].company!!.name!!.toLowerCase().contains(query!!.toLowerCase())) {

                    }
                }

                binding.rvItemList.apply {
                    adapter = ItemAdapter(context, itemList!!)
                }

                Log.i("query: " , "${query}")
                getClient(query!!, 0)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    private fun getClient (language: String, page: Int) {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: ItemService = retrofit.create(ItemService::class.java)

        service.getItem(language, page).enqueue(object : Callback<ItemResponse> {
            override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                Log.e("Errorrrrrr", t.message.toString())
            }
            override fun onResponse(call: Call<ItemResponse>, response: Response<ItemResponse>) {
                itemList = response.body()!!.data!!
                setUpRecyclerView(response.body()!!.data!!)
                Log.i("onResponse", "${response.body()!!.data!![0].title}")
            }
        })
    }

    private fun setUpRecyclerView(itemList: MutableList<Data>) {
        binding.rvItemList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ItemAdapter(context, itemList)
        }
    }
}
