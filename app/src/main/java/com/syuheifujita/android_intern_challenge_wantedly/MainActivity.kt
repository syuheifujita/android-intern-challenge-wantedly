package com.syuheifujita.android_intern_challenge_wantedly

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.syuheifujita.android_intern_challenge_wantedly.`interface`.ItemService
import com.syuheifujita.android_intern_challenge_wantedly.api.ApiClient
import com.syuheifujita.android_intern_challenge_wantedly.databinding.ActivityMainBinding
import com.syuheifujita.android_intern_challenge_wantedly.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        getClient("java", 3)
    }

    private fun getClient (language: String, page: Int) {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(ApiClient.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: ItemService = retrofit.create(ItemService::class.java)

        service.getItem(language, page).enqueue(object : Callback<ItemResponse> {
            override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                Log.e("Errorrrrrr", t.message.toString())
            }
            override fun onResponse(call: Call<ItemResponse>, response: Response<ItemResponse>) {
                setUpRecyclerView(response.body()!!)
                Log.i("onResponse", "${response.body()!!.data[0].title}")
            }
        })
    }

    private fun setUpRecyclerView(itemList: ItemResponse) {
        binding.rvItemList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ItemAdapter(itemList)
        }
    }
}
