package com.example.wacmachinetest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wacmachinetest.R
import com.example.wacmachinetest.domain.model.HomeItemType
import com.example.wacmachinetest.presentation.ui.theme.WACMachineTestTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadHomeData()
        setContent {
            WACMachineTestTheme {

                val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

                        topBar = {
                            CenterAlignedTopAppBar(
                                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                    containerColor = Color(0XFF92C848),
                                    titleContentColor = MaterialTheme.colorScheme.primary,
                                ),
                                title = {
                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(30.dp),
                                        shape = RoundedCornerShape(10.dp),
                                        colors = CardDefaults.cardColors(
                                            containerColor = Color.White,
                                            contentColor = Color.LightGray
                                        ),
                                        elevation = CardDefaults.cardElevation(
                                            defaultElevation = 6.dp
                                        ),
                                    ) {
                                        Icon(
                                            modifier = Modifier.align(Alignment.End).padding(4.dp),
                                            imageVector = Icons.Outlined.Search,
                                            contentDescription = "Search icon",
                                            tint = Color.LightGray
                                        )
                                    }
                                },
                                navigationIcon = {
                                    Image(
                                        modifier = Modifier.height(25.dp).width(25.dp),
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "Logo"
                                    )
                                },
                                actions = {
                                    IconButton(onClick = { /* do something */ }) {
                                        Icon(
                                            imageVector = Icons.Outlined.Notifications,
                                            contentDescription = "Localized description",
                                            tint = Color.White
                                        )
                                    }
                                },
                                scrollBehavior = scrollBehavior,
                            )
                        },
                    ) { innerPadding ->
                        val homeItems = remember(viewModel.state.homeData) {
                            viewModel.state.homeData?: emptyList()
                        }
                        Column(
                            Modifier
                                .verticalScroll(rememberScrollState())
                                .padding(innerPadding)
                        ) {
                            homeItems.forEach {
                                when(it.type){
                                    HomeItemType.BANNER_SLIDER -> {
                                        if (it.contents.isNotEmpty()) {
                                            BannerSlider(it.contents)
                                        }
                                    }
                                    HomeItemType.BANNER_SINGLE -> BannerSingle(image = it.imageUrl)
                                    HomeItemType.PRODUCTS -> ProductsList(it.title, it.contents)
                                    HomeItemType.CATEGORIES -> Categories(it.title, it.contents)
                                    else -> {}
                                }
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