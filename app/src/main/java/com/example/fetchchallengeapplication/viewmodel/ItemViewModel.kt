package com.example.fetchchallengeapplication.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchchallengeapplication.models.ItemModel
import com.example.fetchchallengeapplication.network.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


// This is the view model where the main API call happens and data is retrieved from the server.
class ItemViewModel() : ViewModel() {

    private val repository = ItemRepository()
    private val _dataList = MutableLiveData<List<ItemModel>>()
    val dataList: LiveData<List<ItemModel>> get() = _dataList

    // This method is used to fetch the data from the server via the API. A co-routine is used to
    // lessen the burden on the UI thread and ensure the API call does not cause problems in rendering of
    // the UI.
    fun fetchData() {
        viewModelScope.launch {
            try {
                val response = repository.getData()

                // We check if response was obtained successfully. If it was, we set dataList variable
                // with the body of the response
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        _dataList.value = response.body()!!
                    }

                    // If unsuccessful, we log the error messages.
                } else {
                    Log.e("TAG", "fetchData: API ERROR " + response.message())
                }
            } catch (e: Exception) {
                // Handle exception by displaying the message.
                Log.e("TAG", "fetchData: Caught Exception " + e.message)
            }
        }
    }
}