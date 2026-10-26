package mx.ibero.reflejos

import kotlin.random.Random
import kotlin.time.TimeMark
import kotlin.time.TimeSource

// Los estados posibles de una ronda del juego.
sealed interface Estado {
    data object Inicio : Estado
    data object Esperando : Estado          // pantalla roja: todavía no toques
    data object Ya : Estado                 // pantalla verde: ¡toca!
    data object Falta : Estado              // tocaste antes de tiempo
    data class Resultado(val ms: Long) : Estado
}

// Toda la lógica del juego. Es Kotlin puro: corre igual en Android, Desktop e iOS.
class Juego(private val reloj: TimeSource = TimeSource.Monotonic) {

    var estado: Estado = Estado.Inicio
        private set

    private var momentoVerde: TimeMark? = null

    // Cuánto esperar antes de poner la pantalla en verde (entre 1.5 y 4 segundos).
    fun esperaAleatoriaMs(): Long = Random.nextLong(1_500, 4_000)

    fun empezar() {
        estado = Estado.Esperando
        momentoVerde = null
    }

    fun ponerVerde() {
        if (estado == Estado.Esperando) {
            estado = Estado.Ya
            momentoVerde = reloj.markNow()
        }
    }

    fun tocar() {
        estado = when (estado) {
            Estado.Esperando -> Estado.Falta
            Estado.Ya -> Estado.Resultado(momentoVerde!!.elapsedNow().inWholeMilliseconds)
            else -> estado
        }
    }
}
