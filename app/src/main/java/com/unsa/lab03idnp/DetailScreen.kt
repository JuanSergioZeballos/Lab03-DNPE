package com.unsa.lab03idnp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(textReceived: String, onBack: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Pantalla de Detalle")
        Text(text = "Parámetro recibido: $textReceived")
        Button(onClick = onBack) {
            Text("Volver")
        }
    }
}
