package mx.ibero.reflejos

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform