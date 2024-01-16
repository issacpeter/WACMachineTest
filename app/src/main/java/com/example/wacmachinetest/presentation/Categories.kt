package com.example.wacmachinetest.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.wacmachinetest.R
import com.example.wacmachinetest.domain.model.Content

@Composable
fun Categories(
    title: String,
    contents: List<Content>
){
    Column {
        HorizontalListTitle(title = title)
        LazyRow {
            items(contents) { content ->
                CategoriesItem(content = content)
            }
        }
    }
}

@Composable
fun CategoriesItem(
    content: Content
){
    Card(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier
            .padding(start = 16.dp, top = 10.dp)
            .width(120.dp)
            .height(110.dp),
        colors = CardDefaults.cardColors(
                containerColor = Color.White,
                contentColor = Color.Black
    )
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .weight(1f)
            .background(Color.White),
            contentAlignment = Alignment.Center) {
            AsyncImage(
                modifier = Modifier.align(Alignment.Center),
                model = content.image_url,
                contentDescription = content.title,
                contentScale = ContentScale.FillHeight
            )
        }
        Text(
            modifier = Modifier.padding(5.dp).fillMaxWidth(),
            text = content.title,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                fontWeight = FontWeight(400),
                color = Color.Black,
            ),
            maxLines = 1
        )
    }
}