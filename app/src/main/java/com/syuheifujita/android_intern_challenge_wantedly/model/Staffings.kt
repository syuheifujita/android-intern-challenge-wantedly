package com.syuheifujita.android_intern_challenge_wantedly.model

import java.io.Serializable

data class Staffings (
    val user_id: Int,
    val is_leader: Boolean,
    val name: String,
    val facebook_uid: String,
    val description: String
): Serializable
