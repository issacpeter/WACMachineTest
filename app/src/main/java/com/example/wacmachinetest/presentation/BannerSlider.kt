package com.example.wacmachinetest.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.wacmachinetest.domain.model.Content

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerSlider(
    contents: List<Content>,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(
        pageCount = { contents.size }
    )

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxWidth()
    ) { page ->
        AsyncImage(
            model = contents[page].image_url,
            contentDescription = "Image",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f)
        )
    }

    PagerIndicator(pagerState = pagerState)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    val inactiveColor = Color.LightGray
    val activeColor = Color.Black

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pagerState.pageCount) {
            val backgroundColor = if (pagerState.currentPage == it) activeColor else inactiveColor
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(backgroundColor)
            )
        }
    }
}