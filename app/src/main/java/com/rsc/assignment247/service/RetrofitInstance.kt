package com.rsc.assignment247.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        private var retrofit: Retrofit? = null
        private const val BASE_URL: String = "https://gorest.co.in/"

        fun getService(): RetrofitService? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create<RetrofitService>(RetrofitService::class.java)
        }

    }
}