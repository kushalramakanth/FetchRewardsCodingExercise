package com.example.fetchchallengeapplication.network

import com.example.fetchchallengeapplication.models.ItemModel
import retrofit2.Response
import retrofit2.http.GET

// This is the ApiService interface which holds all the API calls present in this app (under the same base url)
// Here, we make a GET request to the endpoint hiring.json and use the getData() method to perform the call.
// The response is a list of type ItemModel data class
interface ApiService {
    @GET("hiring.json")
    suspend fun getData(): Response<List<ItemModel>>
}