# Ejecutar y verificar Reflejos KMP

Aplicación Kotlin Multiplatform completa para comprobar su funcionamiento en Desktop y Android; iOS es opcional en Mac con Apple Silicon y Xcode. La rama de la actividad es `solucion`.

## Abrir

La opción más sencilla es descomprimir `Reflejos_KMP_Proyecto.zip` y abrir la carpeta Reflejos que contiene settings.gradle.kts en Android Studio. El ZIP contiene la aplicación terminada y no requiere Git.

También puedes clonar la rama completa:

```sh
git clone -b solucion https://github.com/andres-ruhell/reflejos-kmp.git
cd reflejos-kmp
```

Deja terminar Sync. El Manual de instalación de Kotlin Multiplatform prepara las herramientas y verifica una plantilla; la minipráctica comprueba esta aplicación.

## Ejecutar

En el IDE selecciona Desktop y pulsa Run. Para Android, enciende el emulador, selecciona androidApp y pulsa Run. En Mac puedes abrir iosApp/iosApp.xcodeproj con Xcode y ejecutar el esquema iosApp en un simulador.

Desktop desde terminal, en macOS:

```sh
./gradlew :desktopApp:run
```

Desktop desde PowerShell, en Windows:

```powershell
.\gradlew.bat :desktopApp:run
```

Debe aparecer una pantalla morada. Comprueba inicio, espera al verde, resultado en ms, toque anticipado, récord y repetición. El código ya está implementado; la actividad consiste en ejecutarlo y registrar sus resultados.

## Pruebas automáticas

macOS:

```sh
./gradlew :shared:jvmTest :shared:testAndroidHostTest
```

Windows PowerShell:

```powershell
.\gradlew.bat :shared:jvmTest :shared:testAndroidHostTest
```

Deben pasar las cuatro pruebas de JuegoTest en cada destino. Puede haber pruebas adicionales de plantilla. Android host verifica lógica en la computadora; también hay que probar visualmente la aplicación en el emulador.

Solo en Mac con Apple Silicon:

```sh
./gradlew :shared:iosSimulatorArm64Test
```

Registra las comprobaciones y capturas indicadas en `Registro_Resultados.md`. El récord es de la sesión y no persiste después de cerrar la app.

Versiones: Kotlin 2.4.20, Compose Multiplatform 1.12.1, AGP 9.1.1, Gradle 9.5.1, daemon Azul JDK 21 y Ktor 3.6.0. Conserva las versiones del proyecto.

El envío remoto es opcional; un resultado local permite completar la actividad. Si se utiliza el servicio, consulta `Ranking_opcional.md`. El juego de preguntas ¿Dónde va? se distribuye por separado.
