package com.syuheifujita.android_intern_challenge_wantedly.model

import java.io.Serializable

data class Leader (
    val name_ja: String,
    val name_en: String,
    val facebook_uid: String
): Serializable
