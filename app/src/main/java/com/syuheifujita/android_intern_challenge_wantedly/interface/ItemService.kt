package com.syuheifujita.android_intern_challenge_wantedly.`interface`

import com.syuheifujita.android_intern_challenge_wantedly.model.ItemResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ItemService {

    @GET("api/v1/projects")
    fun getItem(
        @Query("q") language: String?,
        @Query("page") page: Int
    ): Call<ItemResponse>
}
