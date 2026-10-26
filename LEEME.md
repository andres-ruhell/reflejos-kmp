# Reflejos KMP

Andrés Ruiz Hellemann y Salvador Ulibarri · Aplicaciones Móviles · IBERO

## Para alumnos

1. Antes de clase, instala Android Studio y el plugin **Kotlin Multiplatform** desde Settings → Plugins → Marketplace. Reinicia el IDE.
2. Clona [reflejos-kmp](https://github.com/andres-ruhell/reflejos-kmp). Empieza en `inicial` y espera a que termine Sync.
3. Ejecuta `desktopApp [hot]`. Si no aparece, usa `./gradlew :desktopApp:run` en la terminal del proyecto (Windows: `gradlew.bat :desktopApp:run`). Debe abrir una pantalla morada. Termina las descargas en casa: Gradle fija un JDK Azul 21 y lo descarga si falta.
4. Sigue los cuatro hitos de la minipráctica. No necesitas crear otro proyecto, instalar Ktor ni crear tu propia cuenta de Supabase.
5. Prueba primero Desktop y después Android. Enciende el emulador antes de compilar. Para ejecutar iOS necesitas Mac, Xcode y un simulador.

El código está en `shared/src/<sourceSet>/kotlin/mx/ibero/reflejos/`. Escritorio usa `jvmMain`. La plantilla conserva `Platform*.kt`; la práctica agrega `Plataforma*.kt` en el hito 3.

| Rama | Resultado esperado |
|---|---|
| `inicial` | Pantalla morada; 2 de 4 pruebas de JuegoTest fallan por los TODO |
| `hito1` | Las 4 pruebas de JuegoTest pasan |
| `hito2` | Juego rojo → verde → tiempo; tocar en rojo produce falta |
| `hito3` | Muestra plataforma; incluye los actual de Android, Desktop e iOS |
| `solucion` | Juego completo; intenta enviar al ranking |

Pruebas: `./gradlew :shared:jvmTest`. Android host: `./gradlew :shared:testAndroidHostTest` (lógica en la computadora, no pantalla del emulador). En Mac: `./gradlew :shared:iosSimulatorArm64Test`. La plantilla agrega otras pruebas, por lo que el total puede ser mayor que 4.

Si te atrasas, guarda antes de cambiar de rama:

```bash
git stash push -u -m "Mi avance"
git switch hito1
```

Elige hito1, hito2, hito3 o solucion según el punto al que quieras llegar. Tu avance queda en `git stash list`. Evita `checkout -f`, porque descarta cambios.

## Preparación docente

El proyecto ya contiene Ktor 3.6.0 y el permiso INTERNET. Versiones fijadas: Kotlin 2.4.20, Compose Multiplatform 1.12.1, AGP 9.1.1 y Gradle 9.5.1. Conservarlas durante la práctica.

Para reconstruir las ramas desde una plantilla nueva con git propio: agrega Ktor core a commonMain, OkHttp a androidMain y jvmMain, Darwin a iosMain y el permiso INTERNET en androidApp/src/main/AndroidManifest.xml. Después ejecuta armar-ramas.sh desde la raíz. No se ejecuta sobre el repositorio que ya tiene las ramas. Los alumnos clonan el proyecto preparado.

### Ranking opcional

1. En un proyecto gratuito de Supabase exclusivo de la clase, ejecuta `supabase.sql` en SQL Editor. Crea dos tablas y permite a anon solo SELECT e INSERT. Los tableros consultan periódicamente; no hace falta activar Realtime.
2. Copia Project URL y la llave **publishable** desde Settings → API Keys. Nunca uses service_role, sb_secret_ ni la contraseña de la base de datos en la app o HTML.
3. Configura Config.kt antes de distribuir el proyecto. En tablero.html puedes pegar URL y llave pública en el formulario. donde-va.html acepta `?url=...&key=...`; agrega `&tablero` para su ranking.
4. Comprueba un envío real y verifica su fila en el tablero. El ranking de reflejos acepta 80–5000 ms; fuera de ese rango el resultado se conserva localmente.
5. Usar apodos y datos de aula. El cliente puede falsificar tiempos: el ranking no sirve para premios, calificaciones ni conclusiones sobre rendimiento entre plataformas.

Sin backend, el juego Kotlin y el ejercicio web siguen funcionando. Si aparece «No enviado: resultado local», revisa conexión, URL, llave, permisos y el rango del tiempo.

### Actividad web

Abre donde-va.html directamente para practicar en esa computadora. **Clase** usa 12 preguntas con reloj (3 por ronda); **Repaso** usa las 28 sin reloj y permite revisar errores. Solo Clase envía puntos al ranking.

Para celulares, publica `docs/` con GitHub Pages y comparte su URL HTTPS. Una ruta file:///Users/andres/... solo funciona en la Mac que tiene ese archivo.

Antes de presentar: Sync terminado; hito1 probado; emulador y simulador abiertos; solución previamente compilada; tablero probado con un envío real o modalidad local anunciada; QR apuntando a la página publicada.

Nueva ronda del tablero filtra jugadas desde ese momento, sin borrar datos. Después de la clase puedes pausar el proyecto en Supabase. Los DROP comentados en el SQL eliminan las tablas: solo ejecutarlos si eso es lo que buscas.
