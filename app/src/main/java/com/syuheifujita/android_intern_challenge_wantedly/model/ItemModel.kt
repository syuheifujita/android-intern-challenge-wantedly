package com.syuheifujita.android_intern_challenge_wantedly.model

import java.io.Serializable

data class ItemModel(
//    val image: Image,
    val lookingFor: String,
    val title: String
//    val company: Company
): Serializable

//data class Image (
//    val original: String
//): Serializable
//
//data class Company (
//    val name: String,
//    val url: String,
//    val avatar: Avatar
//): Serializable
//
//data class Avatar (
//    val original: String
//): Serializable
