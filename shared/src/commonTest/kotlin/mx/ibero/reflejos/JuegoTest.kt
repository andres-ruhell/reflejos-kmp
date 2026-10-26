package mx.ibero.reflejos

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.TestTimeSource

// Estas pruebas corren en todas las plataformas con la misma lógica.
class JuegoTest {

    @Test
    fun alEmpezarSeEsperaElVerde() {
        val juego = Juego()
        juego.empezar()
        assertEquals(Estado.Esperando, juego.estado)
    }

    @Test
    fun tocarAntesDelVerdeEsFalta() {
        val juego = Juego()
        juego.empezar()
        juego.tocar()
        assertEquals(Estado.Falta, juego.estado)
    }

    @Test
    fun mideElTiempoDesdeQueSePoneVerde() {
        val reloj = TestTimeSource()
        val juego = Juego(reloj)
        juego.empezar()
        juego.ponerVerde()
        reloj += 237.milliseconds
        juego.tocar()
        assertEquals(Estado.Resultado(237), juego.estado)
    }

    @Test
    fun laEsperaEstaEntreUnoYMedioYCuatroSegundos() {
        val juego = Juego()
        repeat(100) {
            val espera = juego.esperaAleatoriaMs()
            assertTrue(espera in 1_500 until 4_000)
        }
    }
}
