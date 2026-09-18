package com.unsa.lab03idnp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(onNavigateToDetail: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Pantalla de Inicio")
        Button(onClick = { onNavigateToDetail("Texto de ejemplo") }) {
            Text("Ir a Detalle con parámetro")
        }
    }
}
