package com.syuheifujita.android_intern_challenge_wantedly.api

import android.util.Log
import com.google.gson.Gson
import com.syuheifujita.android_intern_challenge_wantedly.MainActivity
import com.syuheifujita.android_intern_challenge_wantedly.`interface`.ItemService
import com.syuheifujita.android_intern_challenge_wantedly.model.ItemResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val BASE_URL = "https://www.wantedly.com/"

    fun getClient (language: String, page: Int) {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: ItemService = retrofit.create<ItemService>(ItemService::class.java)
        val listCall: Call<ItemResponse> = service.getItem(language, page)

        listCall.enqueue(object : Callback<ItemResponse> {
            override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                Log.e("Errorrrrrr", t.message.toString())
            }

            override fun onResponse(
                call: Call<ItemResponse>,
                response: Response<ItemResponse>
            ) {
                if (response.isSuccessful) {
                    val itemList: ItemResponse? = response.body()
                    Log.i("Responseresult", "$itemList")

//                    val itemResponseJsonString = Gson().toJson(itemList)
//                    setUpUI()
                } else {
                    val rc = response.code()
                    when(rc) {
                        400 -> {
                            Log.e("Error 400", "Bad connection")
                        }
                        404 -> {
                            Log.e("Error 404", "Not Found")
                        }
                        else -> {
                            Log.e("Error", "Generic Error")
                        }
                    }
                }
            }

        })
    }

//    fun setUpUI() {
//        val itemList = Gson().fromJson("", ItemResponse::class.java)
//        for (i in itemList.data.indices) {
//            Log.i("Item Name", itemList.data[i].title)
//        }
//    }
}
