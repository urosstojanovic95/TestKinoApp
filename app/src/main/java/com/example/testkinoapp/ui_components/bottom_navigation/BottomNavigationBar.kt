package com.example.testkinoapp.ui_components.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.testkinoapp.R
import com.example.testkinoapp.utils.Destination

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    items: List<Destination.BottomNavigationScreens>
) {


    BottomNavigation(
        modifier = modifier,
        windowInsets = BottomNavigationDefaults.windowInsets,
        backgroundColor = colorResource(id = R.color.colorPrimary)
    ) {
        items.forEachIndexed { index, item ->

            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = item.iconId),
                        contentDescription = null,
                        tint = if (currentRoute==item.route) {
                            colorResource(id = R.color.colorSecondary)
                        } else {
                            colorResource(id = R.color.textColor)
                        }
                    )
                },
                label = {
                    Text(
                        stringResource(id = item.labelId),
                        color = if (currentRoute==item.route)  {
                            colorResource(id = R.color.colorSecondary)
                        } else {
                            colorResource(id = R.color.textColor)
                        }
                    )
                },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                    }
                })
        }
    }
}