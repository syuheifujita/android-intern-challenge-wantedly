package com.syuheifujita.android_intern_challenge_wantedly.model

import java.io.Serializable

data class ItemResponse (
    val data: List<Data>? = null
)

data class Data (
    val title: String? = null,
    val looking_for: String? = null,
    val image: Image? = null,
    val company: Company? = null
): Serializable

data class Image (
    val original: String? = null
): Serializable

data class Company (
    val name: String? = null,
    val url: String? = null,
    val avatar: Avatar? = null
): Serializable

data class Avatar (
    val original: String? = null
): Serializable
