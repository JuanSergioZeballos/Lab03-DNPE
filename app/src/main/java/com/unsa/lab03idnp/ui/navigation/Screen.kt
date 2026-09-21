package com.unsa.lab03idnp.ui.navigation
 import android.net.Uri
// Definición de las pantallas y sus rutas dentro de la app
sealed class Screen(val route: String) {
    // Ruta de la pantalla principal
    object Home : Screen("home_screen")

    // Ruta de la pantalla secundaria con argumento dinámico
    object Detail : Screen("detail_screen/{userText}") {
        // Función helper para construir la ruta final con el parámetro codificado
        fun createRoute(userText: String): String {
            val encodedText = Uri.encode(userText) // Para qie soporte carecteres especiales "%", "/"
            return "detail_screen/$encodedText"
        }
    }
}