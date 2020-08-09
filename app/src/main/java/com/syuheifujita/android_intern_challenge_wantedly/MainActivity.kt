package com.syuheifujita.android_intern_challenge_wantedly

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.syuheifujita.android_intern_challenge_wantedly.`interface`.ItemService
import com.syuheifujita.android_intern_challenge_wantedly.api.ApiClient
import com.syuheifujita.android_intern_challenge_wantedly.model.ItemModel
import com.syuheifujita.android_intern_challenge_wantedly.model.ItemResponse
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mService: ItemService
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this)
        rv_item_list.layoutManager = layoutManager

        getQuery()

        //        mService = ApiClient.retrofitService

//        getItemList()

//        val itemList = generateDummyList(10)
//        recyclerview.adapter = ItemAdapter(itemList)
//        recyclerview.layoutManager = LinearLayoutManager(this)
    }

    private fun getQuery() {
        getClient("java", 0)
    }

    fun getClient (language: String, page: Int) {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(ApiClient.BASE_URL)
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

//    private fun getItemList() {
//        mService.getWeather().enqueue(object: retrofit2.Callback<MutableList<ItemModel>> {
//            override fun onFailure(call: Call<MutableList<ItemModel>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onResponse(call: Call<MutableList<ItemModel>>, response: Response<MutableList<ItemModel>>) {
//                adapter = ItemAdapter(baseContext, response.body() as MutableList<ItemModel>)
//                adapter.notifyDataSetChanged()
//                rv_item_list.adapter
//            }
//        })
//    }
//
//    private fun generateDummyList(size: Int): List<ItemModel> {
//        val list = ArrayList<ItemModel>()
//        for (i in 0 until size) {
//            val drawable = R.drawable.ic_launcher_background
//            val item = ItemModel(drawable, "Item $i")
//            list += item
//        }
//        return list
//    }
}
