package mx.ibero.reflejos

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun App() {
    val juego = remember { Juego() }
    var estado by remember { mutableStateOf<Estado>(Estado.Inicio) }
    var record by remember { mutableStateOf<Long?>(null) }
    var envio by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    // Mientras esperamos, después de un tiempo al azar la pantalla se pone verde.
    // Si el jugador toca antes, el estado cambia y esta espera se cancela sola.
    LaunchedEffect(estado) {
        if (estado == Estado.Esperando) {
            delay(juego.esperaAleatoriaMs())
            juego.ponerVerde()
            estado = juego.estado
        }
    }

    fun alTocar() {
        // TODO Hito 2.1: según el estado actual, empieza una ronda o registra el toque:
        //   - Inicio, Falta o Resultado → juego.empezar()
        //   - Esperando o Ya            → juego.tocar()
        //   Pista: usa when (estado) { ... } y para Resultado escribe "is Estado.Resultado".
        // Después copia el estado del juego a la pantalla:  estado = juego.estado

        val resultado = estado
        if (resultado is Estado.Resultado) {
            val anterior = record
            if (anterior == null || resultado.ms < anterior) record = resultado.ms

            // Hito 4: quita las dos barras (//) de estas cinco líneas para mandar tu tiempo al ranking.
            // envio = "Enviando..."
            // scope.launch {
            //     val ok = enviarPuntaje(MI_NOMBRE, resultado.ms, plataforma())
            //     envio = if (ok) "En el ranking" else "Sin conexión: solo cuenta aquí"
            // }
        }
    }

    // TODO Hito 2.2: elige color, título y detalle para Ya, Resultado y Falta.
    //   Pista para Resultado: el tiempo está en e.ms  →  "${e.ms} ms"
    val (fondo, titulo, detalle) = when (val e = estado) {
        Estado.Inicio -> Triple(Color(0xFF5B34D6), "Reflejos KMP", "Toca para empezar")
        Estado.Esperando -> Triple(Color(0xFFC0392B), "Espera...", "Toca cuando se ponga verde")
        Estado.Ya -> Triple(Color.Gray, "TODO", "")
        is Estado.Resultado -> Triple(Color.Gray, "TODO", "")
        Estado.Falta -> Triple(Color.Gray, "TODO", "")
    }

    Box(
        // TODO Hito 2.3: agrega  .clickable { alTocar() }  al final del Modifier
        //   para que toda la pantalla responda al toque o al clic.
        modifier = Modifier.fillMaxSize().background(fondo),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(titulo, color = Color.White, fontSize = 56.sp, fontWeight = FontWeight.Bold)
            Text(detalle, color = Color.White, fontSize = 20.sp, textAlign = TextAlign.Center)
            Text("Récord: ${record?.let { "$it ms" } ?: "--"}", color = Color.White, fontSize = 18.sp)

            // Hito 3: cuando exista plataforma(), quita las dos barras de la línea de abajo.
            // Text("${plataforma()} · $MI_NOMBRE", color = Color.White.copy(alpha = 0.75f), fontSize = 14.sp)

            if (envio.isNotEmpty()) {
                Text(envio, color = Color.White.copy(alpha = 0.75f), fontSize = 14.sp)
            }
        }
    }
}
