package com.example.fetchchallengeapplication.userinterface.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.fetchchallengeapplication.models.ItemModel
import com.example.fetchchallengeapplication.ui.theme.FetchChallengeApplicationTheme
import com.example.fetchchallengeapplication.userinterface.screens.ItemClickListener
import com.example.fetchchallengeapplication.userinterface.screens.MainActivityScreen
import com.example.fetchchallengeapplication.viewmodel.ItemViewModel
import java.io.Serializable

// This is the main activity or first screen of the application. In this screen, we make an API call
// to retrieve data and display the listIDs in a list.
class MainActivity : ComponentActivity(), Serializable, ItemClickListener  {
    private val viewModel: ItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Here, we set the static UI content of the page initially.
        // We use a Surface component, which is a basic building block for displaying content
        // Later, we call the Composable function MainActivityScreen, which is responsible for
        // making dynamic UI changes based on data obtained by the API.
        setContent {
            FetchChallengeApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainActivityScreen(viewModel = viewModel, itemClickListener = this)
                }
            }
        }
    }

    // Once the button is clicked, this List data is passed onto the next screen, DetailsActivity as a
    // Parceable bundle and putting the array list into this bundle with the key ITEM_LIST.
    // This is why we write the Parceable code in the ItemModel data class. We then move onto the DetailsActivity screen.

    override fun onItemClicked(list: List<ItemModel>?) {
        val intent = Intent(this, DetailActivity::class.java)
        val bundle = Bundle()
        bundle.putParcelableArrayList("ITEM_LIST", list as ArrayList<ItemModel?>)
        intent.putExtra("bundle", bundle)
        startActivity(intent)
    }
}