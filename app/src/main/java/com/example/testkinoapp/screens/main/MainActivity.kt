package com.example.testkinoapp.screens.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.testkinoapp.R
import com.example.testkinoapp.screens.draw.DrawScreen
import com.example.testkinoapp.screens.live.LiveDrawScreen
import com.example.testkinoapp.screens.results.ResultsScreen
import com.example.testkinoapp.screens.splash.SplashScreen
import com.example.testkinoapp.screens.table.TableScreen
import com.example.testkinoapp.ui_components.bottom_navigation.BottomNavigationBar
import com.example.testkinoapp.ui_components.headers.MainHeader
import com.example.testkinoapp.utils.Destination
import com.example.testkinoapp.utils.NavArguments
import io.ktor.http.RangeUnits

class MainActivity : AppCompatActivity() {
    private var screens: List<Destination.BottomNavigationScreens> = listOf(
        Destination.BottomNavigationScreens.Draw,
        Destination.BottomNavigationScreens.LiveDraw,
        Destination.BottomNavigationScreens.Results,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent()
    }

    private fun setContent() {
        setContent {
            MainPreview()
        }

    }



    @Preview
    @Composable
    private fun MainPreview() {
        val navController = rememberNavController()
        var showSplash by remember { mutableStateOf(true) }
        val bottomBarVisible = remember { mutableStateOf(true) }

        if (showSplash) {
            SplashScreen(onTimeout = { showSplash = false })
        } else {
            Scaffold(
                Modifier.background(color= colorResource(id = R.color.backgroundColor)),
                contentColor = colorResource(id = R.color.backgroundColor),
                containerColor = colorResource(id = R.color.backgroundColor),
                topBar = {
                    MainHeader()
                },
                bottomBar = {
                    AnimatedVisibility(bottomBarVisible.value) {
                        BottomNavigationBar(navController = navController, items = screens)
                    }
                }
            ) { innerPadding ->
                Navigation(
                    navController,
                    Modifier.padding(innerPadding),
                    bottomBarVisible
                )
            }
        }
    }
}

@Composable
fun Navigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    bottomNavigationVisible: MutableState<Boolean>
) {
    NavHost(
        modifier = modifier.background(color = colorResource(id = R.color.backgroundColor)),
        navController = navController,
        startDestination = Destination.BottomNavigationScreens.Draw.route,
    ) {
        composable(route = Destination.BottomNavigationScreens.Draw.route)
        {
            bottomNavigationVisible.value = true
            DrawScreen(onItemClick = {
                navController.navigate("${Destination.TableScreen}/${it.drawId}")
            })
        }
        composable(
            route = "${Destination.TableScreen}/{${NavArguments.DrawId}}",
            arguments = listOf(navArgument(NavArguments.DrawId) { type = NavType.LongType }),
            enterTransition = { slideInVertically(initialOffsetY = { it }) },
            exitTransition = { fadeOut() }
        ) { backStackEntry ->
            val param = backStackEntry.arguments?.getLong(NavArguments.DrawId)
            bottomNavigationVisible.value = false
            TableScreen(
                drawId = param ?: 0,
                openLiveDraw = {
                    navController.navigate(Destination.LiveDraw)
                })
        }

        composable(
            route = Destination.BottomNavigationScreens.LiveDraw.route,

            ) {
            bottomNavigationVisible.value = true
            LiveDrawScreen()
        }
        composable(
            route = Destination.BottomNavigationScreens.Results.route) {
            bottomNavigationVisible.value = true
            ResultsScreen()
        }
    }


}
