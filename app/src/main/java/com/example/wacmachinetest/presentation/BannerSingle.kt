package com.example.wacmachinetest.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun BannerSingle(image: String) {
    AsyncImage(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
            .clip(shape = RoundedCornerShape(
                topStart = 10.dp,
                topEnd = 10.dp,
                bottomStart = 10.dp,
                bottomEnd = 10.dp)),
        model = image,
        contentDescription = "Single Banner",
        contentScale = ContentScale.FillWidth
    )
}

@Preview
@Composable
fun BannerSinglePreview(){
    BannerSingle(image = "https://oxygen-test.webc.in/media/cache/800x0/mobile/banner/i watch New_1675658860.jpg")
}
