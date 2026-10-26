# Minipráctica Reflejos KMP

Aplicación de reflejos para aprender Kotlin Multiplatform en cuatro hitos. Esta carpeta contiene únicamente el proyecto Kotlin y sus recursos de red. El juego de preguntas ¿Dónde va? se distribuye por separado.

## Empezar

1. Instala Android Studio y el plugin Kotlin Multiplatform con sus dependencias; sigue el manual de instalación.
2. Clona este repositorio o descomprime Reflejos_KMP_Proyecto.zip. Abre la carpeta que contiene settings.gradle.kts y espera a que termine Sync.
3. Empieza en `inicial`. En el IDE usa Desktop o desktopApp [hot]. En la terminal del proyecto usa el comando de tu sistema:

macOS:

```sh
./gradlew :desktopApp:run
```

Windows PowerShell:

```powershell
.\gradlew.bat :desktopApp:run
```

Debe abrirse una pantalla morada. El clic se completa en el hito 2. El proyecto ya tiene Ktor y el permiso INTERNET; no generes otro proyecto ni cambies versiones durante la práctica.

Sigue la minipráctica: Juego.kt → App.kt → Plataforma*.kt → Config.kt y envío. El código está en `shared/src/<sourceSet>/kotlin/mx/ibero/reflejos/`; los tests en commonTest; Desktop usa jvmMain.

## Comprobar

macOS:

```sh
./gradlew :shared:jvmTest
```

Windows PowerShell:

```powershell
.\gradlew.bat :shared:jvmTest
```

En inicial fallan dos de las cuatro pruebas de JuegoTest por los TODO; al completar el hito 1 pasan las cuatro. Puede haber pruebas adicionales de la plantilla.

Android: enciende el emulador y ejecuta androidApp desde el IDE. iOS: solo en Mac con Xcode, abre iosApp/iosApp.xcodeproj y ejecuta el esquema iosApp en un simulador.

Versiones del proyecto: Kotlin 2.4.20, Compose Multiplatform 1.12.1, AGP 9.1.1, Gradle 9.5.1, daemon Azul 21 y Ktor 3.6.0. Las descargas automáticas deben terminar antes de empezar los hitos.

El ranking compartido es opcional. El resultado local permite completar la práctica. Consulta `Ranking_opcional.md` si el grupo va a usar Supabase.
