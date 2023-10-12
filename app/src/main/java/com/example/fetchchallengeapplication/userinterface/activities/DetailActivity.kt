package com.example.fetchchallengeapplication.userinterface.activities

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.fetchchallengeapplication.R
import com.example.fetchchallengeapplication.models.ItemModel
import com.example.fetchchallengeapplication.ui.theme.FetchChallengeApplicationTheme
import com.example.fetchchallengeapplication.userinterface.screens.DetailActivityScreen

// In this screen, we are showing the names present in the particular listID that was click
// in an alphabetical order.
class DetailActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // We obtain the bundle from the intent and store the data in itemList. We use the same key to
        // obtain the data.
        val bundle = intent.getBundleExtra("bundle")
        val itemList = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle!!.getParcelableArrayList("ITEM_LIST", ItemModel::class.java)
        } else {
            bundle!!.getSerializable("ITEM_LIST") as? ArrayList<ItemModel>
        }

        // We set the static UI of the page with a topAppBar with a back button and a surface that
        // is used to display the dynamic data using the Composable function present in DetailActivityScreen.kt

        setContent {
            FetchChallengeApplicationTheme {
                // Add a Scaffold with a TopAppBar
                Scaffold(topBar = {
                    TopAppBar(
                        title = { Text(text = "Detail Screen") },
                        colors = TopAppBarDefaults.smallTopAppBarColors(
                            containerColor = colorResource(R.color.top_app_bar_color),
                            titleContentColor = Color.White,
                        ),
                        navigationIcon = {
                            IconButton(onClick = {
                                onBackPressedDispatcher.onBackPressed()
                            }) {
                                Icon(
                                    Icons.Default.ArrowBack,
                                    contentDescription = "Back",
                                    tint = Color.White
                                )
                            }
                        },
                    )
                }) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(60.dp),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        DetailActivityScreen(itemList!!)
                    }
                }
            }
        }

    }
}