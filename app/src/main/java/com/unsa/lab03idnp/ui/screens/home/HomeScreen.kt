package com.unsa.lab03idnp.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(onNavigateToDetail: (String) -> Unit) {
    // Usar rememberSaveable si se quiere persistir en giro de pantalla
    var textoIngresado by remember { mutableStateOf("")}
    var mostrarError by remember { mutableStateOf(false)}

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Pantalla de Inicio")

        OutlinedTextField(
            value = textoIngresado,
            // actualiza al escribir
            onValueChange = {
                textoIngresado = it
                if(it.isNotBlank()) mostrarError = false
            },
            label = {
                Text(
                    text = "Ingresar Texto"
                )
            },
            isError = mostrarError, //
            supportingText = {
                if (mostrarError){
                    Text( text = "El campo no puede estar vacio")
                }
            }
        )
        Button(onClick = {
            if (textoIngresado.isNotBlank()){
                onNavigateToDetail(textoIngresado)
            } else {
                mostrarError = true // Activa el estado de error
            }
        }) {
            Text("Ir a Detalle con parámetro")
        }
    }
}
