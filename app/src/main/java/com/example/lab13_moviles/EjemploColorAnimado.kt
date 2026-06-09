package com.example.lab13_moviles

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun EjemploColorAnimado() {
    // 1. Estado para alternar entre dos colores
    var isBlue by remember { mutableStateOf(true) }

    // 2. animateColorAsState para crear la transición suave
    val animatedColor by animateColorAsState(
        targetValue = if (isBlue) Color.Blue else Color.Green,
        // 3. Especificación de la animación (tween para duración fija)
        animationSpec = tween(durationMillis = 1000),
        label = "colorAnimation"
    )

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { isBlue = !isBlue }) {
            Text("Cambiar Color")
        }

        Spacer(modifier = Modifier.height(32.dp))

        // El cuadro que cambia de color
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(animatedColor) // Color animado aplicado
        )
    }
}