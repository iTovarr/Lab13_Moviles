package com.example.lab13_moviles

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun EjemploAnimacionTamanoPosicion() {
    var expanded by remember { mutableStateOf(false) }

    // Animamos tanto el tamaño como el desplazamiento (offset)
    val size by animateDpAsState(
        targetValue = if (expanded) 200.dp else 100.dp,
        animationSpec = spring(),
        label = "size"
    )

    val offsetX by animateDpAsState(
        targetValue = if (expanded) 100.dp else 0.dp,
        animationSpec = spring(),
        label = "offset"
    )

    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = { expanded = !expanded }) {
            Text("Mover y Escalar")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // El orden de los modificadores es crucial:
        // Primero el offset para moverlo, luego el tamaño para escalarlo
        Box(
            modifier = Modifier
                .offset(x = offsetX, y = 0.dp)
                .size(size)
                .background(Color.Red)
        )
    }
}