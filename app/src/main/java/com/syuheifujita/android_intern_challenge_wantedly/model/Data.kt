package com.syuheifujita.android_intern_challenge_wantedly.model

import java.io.Serializable

data class Data (
//    val id: Double,
    val title: String,
//    ,
//    val published_at: String,
//    val suppor_count: Int,
//    val page_view: Double,
//    val location: String,
//    val location_suffix: String,
//    val description: String,
    val looking_for: String,
    val image: Image,
//    val use_webview: Boolean,
    val company: Company
//    val staffing_count: Int,
//    val staffings: List<Staffings>,
//    val leader: Leader,
//    val video_available: Boolean,
//    val category_images: List<CategoryImages>,
//    val tags: List<Tags>,
//    val category_message: String,
//    val can_support: Boolean,
//    val supported: Boolean,
//    val applied: Boolean,
//    val can_bookmark: Boolean
): Serializable

data class Image (
    val original: String
): Serializable

data class Company (
    val name: String,
    val url: String,
    val avatar: Avatar
): Serializable

data class Avatar (
    val original: String
): Serializable
