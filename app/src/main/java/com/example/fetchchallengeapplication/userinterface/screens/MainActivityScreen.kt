package com.example.fetchchallengeapplication.userinterface.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetchchallengeapplication.models.ItemModel
import com.example.fetchchallengeapplication.viewmodel.ItemViewModel

// We use this interface to make the click action happen in the main activity. This is done because we
// usually cannot navigate from a function and need to be in the context of an activity or fragment to
// change screens. We declare this method here but write its definition in MainActivity.
interface ItemClickListener {
    fun onItemClicked(items: List<ItemModel>?)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainActivityScreen(viewModel: ItemViewModel, itemClickListener: ItemClickListener) {
    val items by viewModel.dataList.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }

    var map = HashMap<Int, MutableList<ItemModel>>()

    // Here, we are sorting the list according to the listID.
    // We use a hashmap of type {Int : list[]} to store the values. The key  is the listID and
    // value is the list of data of type ItemModel, which has that particular listID
    for (item in items) {
        // Here, we disregard the values with null or empty names
        if (item.name != "" && item.name != null) {

            // If the listID already exists, we append to existing list else, we create a new list with
            // the item.
            if (map.containsKey(item.listId)) {
                map[item.listId]?.add(item)
            } else {
                map[item.listId] = mutableListOf(item)
            }
        }
    }

    // Here is the dynamic UI of the app where we display the list of unique listIDs present in our data.
    // Each row consists of a Card View or component with a Text component inside of it (which shows the
    // listID value). The card is also clickable and calls the onItemClicked method defined in MainActivity
    // with the list of ItemModel that is present under that particular listID.
    LazyColumn {
        items(map.keys.toList()) { key ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),

                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                onClick = {
                    itemClickListener.onItemClicked(map[key])
                }
            ) {
                Column(
                    modifier = Modifier.padding(25.dp),
                ) {
                    Text(
                        text = "List ID: $key",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}