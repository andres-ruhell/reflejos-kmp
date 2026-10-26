package mx.ibero.reflejos

actual fun plataforma(): String = "Desktop · ${System.getProperty("os.name")}"
