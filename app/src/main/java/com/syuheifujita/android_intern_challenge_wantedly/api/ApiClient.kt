package com.syuheifujita.android_intern_challenge_wantedly.api

import android.util.Log
import com.google.gson.Gson
import com.syuheifujita.android_intern_challenge_wantedly.Constant
import com.syuheifujita.android_intern_challenge_wantedly.MainActivity
import com.syuheifujita.android_intern_challenge_wantedly.`interface`.ItemService
import com.syuheifujita.android_intern_challenge_wantedly.model.ItemResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
//    fun getClient (language: String, page: Int) {
//        val retrofit: Retrofit = Retrofit.Builder()
//            .baseUrl(Constant.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val service: ItemService = retrofit.create(ItemService::class.java)
//
//        service.getItem(language, page).enqueue(object : Callback<ItemResponse> {
//            override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
//                Log.e("Errorrrrrr", t.message.toString())
//            }
//            override fun onResponse(call: Call<ItemResponse>, response: Response<ItemResponse>) {
//                setUpRecyclerView(response.body()!!)
//                Log.i("onResponse", "${response.body()!!.data[0].title}")
//            }
//        })
//    }
}
