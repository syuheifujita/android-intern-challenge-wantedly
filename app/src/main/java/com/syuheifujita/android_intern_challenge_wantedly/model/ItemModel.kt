package com.syuheifujita.android_intern_challenge_wantedly.model

data class ItemModel(
    val imageUrl: Int,
    val lookingFor: String? = null,
    val title: String? = null,
    val avatar: String? = null,
    val companyName: String? = null
) {
}
