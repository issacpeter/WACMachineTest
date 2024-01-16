package com.example.wacmachinetest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.wacmachinetest.domain.model.HomeItemType
import com.example.wacmachinetest.presentation.ui.theme.WACMachineTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadHomeData()
        setContent {
            WACMachineTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val homeItems = remember(viewModel.state.homeData) {
                        viewModel.state.homeData?: emptyList()
                    }
                    Column(
                        Modifier.verticalScroll(rememberScrollState())
                    ) {
                        homeItems.forEach {
                            when(it.type){
                                HomeItemType.BANNER_SLIDER -> {
                                    if (it.contents.isNotEmpty()) {
                                        BannerSlider(it.contents)
                                    }
                                }

                                HomeItemType.BANNER_SINGLE -> BannerSingle(image = it.imageUrl)
                                else -> {}
                            }
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WACMachineTestTheme {
        Greeting("Android")
    }
}