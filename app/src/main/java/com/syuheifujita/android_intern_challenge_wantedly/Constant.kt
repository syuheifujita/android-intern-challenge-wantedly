package com.syuheifujita.android_intern_challenge_wantedly

import com.syuheifujita.android_intern_challenge_wantedly.`interface`.ItemService
import com.syuheifujita.android_intern_challenge_wantedly.api.ApiClient
import retrofit2.Retrofit

object Constant {
    const val BASE_URL = "https://www.wantedly.com/"

    // Intent.extrasのkey
    const val EXTRA_MESSAGE_IMAGE_URL = "com.example.testactivitydatatrans.MESSAGE"
    const val EXTRA_MESSAGE_LOOKING_FOR = "com.example.testactivitydatatrans.MESSAGE"
    const val EXTRA_MESSAGE_TITLE = "com.example.testactivitydatatrans.MESSAGE"
    const val EXTRA_MESSAGE_AVATAR = "com.example.testactivitydatatrans.MESSAGE"
    const val EXTRA_MESSAGE_COMPANY_NAME = "com.example.testactivitydatatrans.MESSAGE"
}
