package mx.ibero.reflejos

import io.ktor.client.HttpClient
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess

// Un solo cliente HTTP para todas las plataformas.
// Ktor elige el motor de cada una: OkHttp en Android y Desktop, Darwin en iOS.
private val cliente = HttpClient()

// Si la red o el servidor rechazan el envío, regresa false y el juego sigue.
suspend fun enviarPuntaje(nombre: String, ms: Long, plataforma: String): Boolean = try {
    val json = """{"nombre":"${limpiar(nombre)}","ms":$ms,"plataforma":"${limpiar(plataforma)}"}"""
    val respuesta = cliente.post("$SUPABASE_URL/rest/v1/puntajes") {
        header("apikey", SUPABASE_KEY)
        // Las llaves anon antiguas son JWT y también van en Authorization.
        if (SUPABASE_KEY.startsWith("eyJ")) header("Authorization", "Bearer $SUPABASE_KEY")
        contentType(ContentType.Application.Json)
        setBody(json)
    }
    respuesta.status.isSuccess()
} catch (e: Exception) {
    false
}

private fun limpiar(texto: String): String =
    texto.replace("\\", "").replace("\"", "").trim().take(30).ifEmpty { "Anónimo" }
