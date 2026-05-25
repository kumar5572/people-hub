package com.kumar.peoplehub.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.kumar.peoplehub.model.User
import com.kumar.peoplehub.ui.detail.UserDetailScreen
import com.kumar.peoplehub.ui.list.UsersScreen

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "users"
    ) {

        composable("users") {

            UsersScreen(
                onUserClick = { user ->

                    val userJson =
                        Uri.encode(
                            Gson().toJson(user)
                        )

                    navController.navigate(
                        "detail/$userJson"
                    )
                }
            )
        }

        composable(
            route = "detail/{user}",
            arguments = listOf(
                navArgument("user") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val userJson =
                backStackEntry.arguments
                    ?.getString("user")
                    .orEmpty()

            val user =
                Gson().fromJson(
                    userJson,
                    User::class.java
                )

            UserDetailScreen(
                user = user,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}