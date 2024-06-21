package com.uolimzhanov.kattabozortest.ui.generic

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import coil3.compose.SubcomposeAsyncImage
import com.uolimzhanov.kattabozortest.R
import com.uolimzhanov.kattabozortest.model.entity.Attribute
import com.uolimzhanov.kattabozortest.model.entity.Image
import com.uolimzhanov.kattabozortest.model.entity.Offer
import com.uolimzhanov.kattabozortest.ui.theme.KattaBozorTestTheme

/**
 * Created by uolimzhanov on 20.06.2024
 */
@Composable
fun OfferItem(
    modifier: Modifier = Modifier,
    offer: Offer = Offer(),
    onClick: (Offer) -> Unit = {}
) {
    Card(
        modifier = modifier
            .aspectRatio(3f / 4)
            .clickable {
                onClick(offer)
            },
    ) {
        OfferItemImage(
            modifier = Modifier.fillMaxWidth().weight(3f),
            imageUrl = offer.image?.url
        )
        ListItem(
            overlineContent = {
                Text(
                    text = "${offer.brand}",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            headlineContent = {
                Text(
                    text = "${offer.name}",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            supportingContent = {
                Text(
                    text = "${offer.merchant}",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            modifier = Modifier.weight(1.5f),
            colors = ListItemDefaults.colors(
                containerColor = CardDefaults.cardColors().containerColor
            )
        )
    }
}

@PreviewLightDark
@Composable
private fun StoreItemPreview() {
    KattaBozorTestTheme{
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ){
                OfferItem(
                    modifier = Modifier,
                    offer = Offer(
                        name = "Google pixel 5",
                        brand = "Google",
                        merchant = "Ali",
                        attributes = listOf(
                            Attribute(
                                name = "ram",
                                value = "8gb"
                            )
                        ),
                        image = Image(
                            width = 124,
                            height = 134,
                            url = null
                        )
                    )
                )

        }
    }
}