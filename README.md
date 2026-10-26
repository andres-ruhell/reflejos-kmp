# Reflejos KMP

Práctica de Andrés Ruiz Hellemann y Salvador Ulibarri · Aplicaciones Móviles · IBERO.

Empieza en **inicial**. Instala el plugin Kotlin Multiplatform en Android Studio, reinicia y abre este proyecto. Termina Sync antes de clase.

```bash
./gradlew :desktopApp:run
./gradlew :shared:jvmTest
```

En Windows usa `gradlew.bat`. Inicial abre una pantalla morada y deben fallar 2 de las 4 pruebas de JuegoTest por los TODO. En hito1 pasan las 4. La plantilla agrega otras pruebas; el total mostrado puede ser mayor.

Ramas: inicial → hito1 → hito2 → hito3 → solucion. Guarda antes de cambiar: `git stash push -u -m "Mi avance"`, luego `git switch hito1` (o el hito que necesites).

Hitos: lógica en Juego.kt, interfaz en App.kt, expect/actual en Plataforma*.kt y envío con Ktor. Paquete mx.ibero.reflejos; módulo shared; escritorio usa jvmMain. No necesitas crear tu propio proyecto ni configurar Ktor en clase.

Android: `./gradlew :androidApp:assembleDebug`; ejecuta androidApp en el IDE con un emulador encendido. iOS requiere Mac y Xcode: abre iosApp/iosApp.xcodeproj y ejecuta el esquema iosApp en un simulador. El actual iOS debe crearse en el hito 3, aunque pruebes solo Desktop.

Versiones fijadas: Kotlin 2.4.20, Compose Multiplatform 1.12.1, AGP 9.1.1, Gradle 9.5.1, JDK del daemon Azul 21 y Ktor 3.6.0. Gradle descarga lo que falte.

Sin Supabase el juego sigue funcionando. Para el ranking configura URL y llave pública en Config.kt y ejecuta supabase.sql en un proyecto exclusivo de aula. Nunca agregues contraseñas o claves de servicio. El ranking admite tiempos de 80–5000 ms; un envío rechazado conserva el resultado local.

[¿Dónde va?](https://andres-ruhell.github.io/reflejos-kmp/donde-va.html): Clase tiene 12 preguntas con reloj; Repaso tiene 28 sin reloj. También puedes abrir docs/donde-va.html sin servidor. Solo Clase envía resultados al ranking.

Consulta LEEME.md para la preparación docente. Es una demo de aula; los datos del cliente no se comprueban contra trampas y no sirven para premios, calificaciones ni conclusiones de rendimiento entre plataformas.
