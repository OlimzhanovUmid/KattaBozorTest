package com.uolimzhanov.kattabozortest.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.pulltorefresh.pullToRefresh
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.uolimzhanov.kattabozortest.model.entity.Attribute
import com.uolimzhanov.kattabozortest.model.entity.Image
import com.uolimzhanov.kattabozortest.model.entity.Offer
import com.uolimzhanov.kattabozortest.ui.generic.OfferItem
import com.uolimzhanov.kattabozortest.ui.theme.KattaBozorTestTheme
import org.koin.androidx.compose.koinViewModel

/**
 * Created by uolimzhanov on 20.06.2024
 */
@Composable
fun OffersScreenRoot(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: OffersViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    OffersScreen(
        modifier = modifier,
        offers = state.offers,
        onRefresh = viewModel::onGetOffers,
        isLoading = state.isLoading,
        onOfferClick = { offer ->
      /*      navController.navigate(Screens.Product(
                offer = Json.encodeToJsonElement(offer).toString()
            ))*/
        }
    )
}
typealias Id = Int

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OffersScreen(
    modifier: Modifier = Modifier,
    offers: List<Offer> = emptyList(),
    onOfferClick: (Offer) -> Unit = {},
    onRefresh: () -> Unit = {},
    isLoading: Boolean = false,
    isSent: Boolean = false,
    onSend: (Boolean) -> Unit = {}
) {
    val pullRefreshState = rememberPullToRefreshState()
    val lazyGridState = rememberLazyGridState()

    LaunchedEffect(isLoading) {
        if (!isLoading) {
            pullRefreshState.animateToHidden()
        }
    }
    var sentIds = remember {
        mutableSetOf<Id>()
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        state = lazyGridState,
        modifier = modifier
            .pullToRefresh(
                isRefreshing = isLoading,
                state = pullRefreshState,
                onRefresh = onRefresh
            )
    ) {
        items(offers) { offer ->
            OfferItem(
                modifier = Modifier
                    .padding(2.dp),
                offer = offer,
                onClick = onOfferClick,
                isSent = isSent,
                onSend = onSend
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun OffersScreenPreview() {
    KattaBozorTestTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ){
            OffersScreen(
                modifier = Modifier.fillMaxSize(),
                isLoading = true,
                offers = listOf(
                    Offer(
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
                            width = 154,
                            height = 124,
                            url = null
                        )
                    ),
                    Offer(
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
                            width = 154,
                            height = 124,
                            url = null
                        )
                    ),
                    Offer(
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
                            width = 154,
                            height = 124,
                            url = null
                        )
                    ),
                    Offer(
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
                            width = 154,
                            height = 124,
                            url = null
                        )
                    )
                )
            )
        }
    }
}