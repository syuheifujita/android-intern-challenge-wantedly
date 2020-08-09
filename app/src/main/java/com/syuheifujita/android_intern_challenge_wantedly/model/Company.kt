package com.syuheifujita.android_intern_challenge_wantedly.model

import java.io.Serializable

data class Company (
    val id: Int,
    val name: String,
    val founder: String,
    val founder_on: String,
    val payroll_number: Int,
    val adress_prefix: String,
    val adress_suffix: String,
    val latitude: Double,
    val longitude: Double,
    val url: String,
    val font_color_code: String,
    val avatar: Avatar
): Serializable