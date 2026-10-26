package mx.ibero.reflejos

import android.os.Build

actual fun plataforma(): String = "Android · ${Build.MODEL}"
