package com.example.fetchchallengeapplication.network

import com.example.fetchchallengeapplication.models.ItemModel
import retrofit2.Response

// This is the data repository that can be used to fetch the data obtained by the API.
class ItemRepository {
        private val items = RetrofitInstance.api

        suspend fun getData(): Response<List<ItemModel>> {
            return items.getData()
        }
}