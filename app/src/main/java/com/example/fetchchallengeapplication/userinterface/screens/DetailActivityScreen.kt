package com.example.fetchchallengeapplication.userinterface.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetchchallengeapplication.models.ItemModel

// This is the composable function used to display the data we obtained above. We pass that itemList
// as a parameter. We add all the names into a MutableList and sort that list.
// Since there are numbers as well, we use substring to obtain the numbers after "Item " and sort the
// names based on the numbers. Eg: Item 23 comes before Item 85.
@Composable
fun DetailActivityScreen(itemList: List<ItemModel>) {

    var list: MutableList<String> = ArrayList()

    for (i in itemList) {
        list.add(i.name)
    }

    list.sortBy { it.substringAfter("Item ").toInt() }

    LazyColumn {
        items(list) { name ->
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier
                        .width(250.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(10.dp),

                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp),
                    ) {
                        Text(
                            text = "Name: $name",
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
}