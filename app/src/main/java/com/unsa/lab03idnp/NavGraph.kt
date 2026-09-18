package com.unsa.lab03idnp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation() {
    // 1. Inicialización del controlador de navegación
    val navController = rememberNavController()

    // 2. Definición del NavHost y ruta de inicio
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        // Destino 1: Pantalla Principal (Origen)
        composable(route = Screen.Home.route) {
            HomeScreen(
                onNavigateToDetail = { textToSend ->
                    // Navega a la ruta sustituyendo el parámetro
                    navController.navigate(Screen.Detail.createRoute(textToSend))
                }
            )
        }

        // Destino 2: Pantalla Secundaria (Destino con parámetro)
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument("userText") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            // Recepción y extracción del parámetro de texto
            val textReceived = backStackEntry.arguments?.getString("userText") ?: ""

            DetailScreen(
                textReceived = textReceived,
                onBack = {
                    // Acción para volver a la pantalla anterior
                    navController.popBackStack()
                }
            )
        }
    }
}