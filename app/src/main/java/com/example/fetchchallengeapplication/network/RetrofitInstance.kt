package com.example.fetchchallengeapplication.network

import com.example.fetchchallengeapplication.App
import com.example.fetchchallengeapplication.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// This is the singular instance of retrofit which can be used everywhere in the app.
// This is loaded by lazy and is only built when it is called and this same instance can be used
// throughout the app.

// We can store the Base URL and individual API endpoints in a single place: strings.xml for easy use
// and to make it easy to make changes.

object RetrofitInstance {
    private var BASE_URL = App.context.getString(R.string.base_url)

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
