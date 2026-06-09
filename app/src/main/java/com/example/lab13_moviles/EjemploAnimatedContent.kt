package com.example.lab13_moviles

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// 1. Definición de estados
enum class UiState { Loading, Content, Error }

@Composable
fun EjemploAnimatedContent() {
    var currentState by remember { mutableStateOf(UiState.Loading) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        // Botones para cambiar de estado
        Row {
            Button(onClick = { currentState = UiState.Loading }) { Text("Cargando") }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { currentState = UiState.Content }) { Text("Éxito") }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { currentState = UiState.Error }) { Text("Error") }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // 2. AnimatedContent para transiciones fluidas
        AnimatedContent(
            targetState = currentState,
            transitionSpec = {
                // 3. Configuración de efectos personalizados
                fadeIn(animationSpec = tween(500)) togetherWith fadeOut(animationSpec = tween(500))
            },
            label = "stateAnimation"
        ) { targetState ->
            // Contenido según el estado
            when (targetState) {
                UiState.Loading -> Text("Cargando información...", style = MaterialTheme.typography.headlineSmall)
                UiState.Content -> Text("¡Contenido cargado con éxito! ✅", style = MaterialTheme.typography.headlineSmall)
                UiState.Error -> Text("Ocurrió un error. ❌", style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.error)
            }
        }
    }
}