package com.uolimzhanov.kattabozortest.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uolimzhanov.kattabozortest.ui.navgraphs.Screens
import com.uolimzhanov.kattabozortest.ui.screens.OffersScreenRoot
import com.uolimzhanov.kattabozortest.ui.screens.OffersViewModel
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
        NavHost(navController = navController, startDestination = Screens.Offers) {
            composable<Screens.Offers> {
                val viewModel = koinViewModel<OffersViewModel>()

                OffersScreenRoot(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    navController = navController,
                    viewModel = viewModel
                )
            }
        }
    }
}