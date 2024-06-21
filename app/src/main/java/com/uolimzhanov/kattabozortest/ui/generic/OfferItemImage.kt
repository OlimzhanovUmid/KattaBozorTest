package com.uolimzhanov.kattabozortest.ui.generic

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil3.compose.SubcomposeAsyncImage
import com.uolimzhanov.kattabozortest.R

/**
 * Created by uolimzhanov on 21.06.2024
 */
@Composable
fun OfferItemImage(
    modifier: Modifier = Modifier,
    imageUrl: String? = null
) {
    SubcomposeAsyncImage(
        model = imageUrl,
        contentScale = ContentScale.Inside,
        contentDescription = null,
        alignment = Alignment.Center,
        error = {
            Box(
                modifier = Modifier.fillMaxSize(0.75f),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.empty_basket),
                    contentDescription = null
                )
            }
        },
        modifier = modifier
    )
}