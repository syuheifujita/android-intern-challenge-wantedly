package com.syuheifujita.android_intern_challenge_wantedly.model

import java.io.Serializable

data class ItemResponse (
    val data: List<Data>
)

data class Data (
    val title: String,
    val looking_for: String,
    val image: Image,
    val company: Company
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
