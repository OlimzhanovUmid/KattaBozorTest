package com.uolimzhanov.kattabozortest.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uolimzhanov.kattabozortest.ui.navgraphs.Screens
import com.uolimzhanov.kattabozortest.ui.screens.OffersScreenRoot
import com.uolimzhanov.kattabozortest.ui.screens.OffersViewModel
import com.uolimzhanov.kattabozortest.ui.screens.offers.ReviewText
import com.uolimzhanov.kattabozortest.ui.screens.offers.reviewText
import com.uolimzhanov.kattabozortest.ui.theme.KattaBozorTestTheme
import org.koin.androidx.compose.koinViewModel

/**
 * Created by uolimzhanov on 19.06.2024
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContainer() {
    val navController = rememberNavController()
    
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Offers")
                }
            )
        }
    ) { paddingValues ->
        var isExpanded by remember {
            mutableStateOf(false)
        }
        NavHost(navController = navController, startDestination = Screens.Offers) {
            composable<Screens.Offers> {
                val pros = "Zuda ham zoʻr telefon hammaga shuni olishni maslat qilaman maza qilib ishlatasz"
                val cons = "Hammasi joyida"
                val comment = "Olsa boladi"
                    ReviewText(
                        text = reviewText(
                            prosText = pros,
                            consText = cons,
                            commentText = comment
                        ),
                        modifier = Modifier
                            .padding(top = 10.dp, start = 15.dp, end = 15.dp)
                            .padding(paddingValues)
                            .clickable {
                                isExpanded = !isExpanded
                                println("is expanded? $isExpanded")
                            },
                        isExpanded = isExpanded,
                        showLessText = "меньше",
                        showMoreText = " ещё",
                        maxLines = 4,
                        onExpand = {
                            isExpanded = !isExpanded
                            println("is expanded? $isExpanded")
                        }
                    )

            }
        }
    }
}