package mx.ibero.reflejos

import platform.UIKit.UIDevice

actual fun plataforma(): String = "iOS · ${UIDevice.currentDevice.model}"
