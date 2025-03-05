package com.clp3z.luziatest.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberMainState(
    navHostController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
): MainState = remember(navHostController) {
    MainState(
        navHostController = navHostController,
        coroutineScope = coroutineScope
    )
}

@Stable
class MainState(
    val navHostController: NavHostController,
    private val coroutineScope: CoroutineScope
) {

    fun navigateTo(destination: Destination) = navHostController.navigate(destination)

    fun onUpClick() = navHostController.navigateUp()
}
