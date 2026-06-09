package com.example.lab13_moviles

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun EjemploAnimatedVisibility() {
    // 1. Estado para controlar la visibilidad
    var visible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Botón que alterna el estado
        Button(onClick = { visible = !visible }) {
            Text(text = if (visible) "Ocultar" else "Mostrar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 2 y 3. AnimatedVisibility con efectos de entrada y salida
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            // El elemento a animar (cuadro de color)
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Blue)
            )
        }
    }
}