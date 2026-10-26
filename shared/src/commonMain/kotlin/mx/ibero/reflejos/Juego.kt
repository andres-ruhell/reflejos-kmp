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

    // Ya está hecha: sirve de ejemplo.
    fun empezar() {
        estado = Estado.Esperando
        momentoVerde = null
    }

    fun ponerVerde() {
        // TODO Hito 1.1: solo si el estado es Esperando,
        //   cambia el estado a Ya y guarda el momento con reloj.markNow()
        TODO("Hito 1.1")
    }

    fun tocar() {
        // TODO Hito 1.2: decide el nuevo estado según el actual:
        //   - Esperando  → Falta (tocaste antes de tiempo)
        //   - Ya         → Resultado con los milisegundos: momentoVerde!!.elapsedNow().inWholeMilliseconds
        //   - cualquier otro → se queda igual
        TODO("Hito 1.2")
    }
}
