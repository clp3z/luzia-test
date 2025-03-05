package com.clp3z.luziatest.app.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.clp3z.luziatest.feature.detail.DetailScreen
import com.clp3z.luziatest.feature.main.MainScreen

@Composable
fun Navigation(mainState: MainState) {
    with(mainState) {
        NavHost(
            navController = navHostController,
            startDestination = Destination.Main
        ) {
            composable<Destination.Main>(
                enterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(300)
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(300)
                    )
                }
            ) {
                MainScreen(
                    onPlanetClick = {
                        navigateTo(Destination.Detail(it.url))
                    }
                )
            }
            composable<Destination.Detail>(
                enterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(300)
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(300)
                    )
                },
                popEnterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(300)
                    )
                },
                popExitTransition = {
                    slideOutOfContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(300)
                    )
                }
            ) {
                val detail = it.toRoute<Destination.Detail>()
                DetailScreen (
                    url = detail.url,
                    onUpClick = { onUpClick() }
                )
            }
        }
    }
}
