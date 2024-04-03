package com.example.contries_project1.ui.theme.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun CountriesNavigationGraph(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.USER_INPUT_SCREEN)
    {
        composable(Routes.USER_INPUT_SCREEN){
            LoginScreen(navController)
        }
        composable(Routes.COUNTRIES_SCREEN){
            Countries(navController)
        }
        composable(Routes.COUNTRIES_DETAILS_SCREEN){
            Countries(navController)
        }
    }
}