# Archivos y ramas de la minipráctica

Trabaja sobre tu copia de inicial. No necesitas cambiar de rama al terminar cada hito; las demás sirven como puntos de recuperación o referencia.

| Rama | Estado esperado |
|---|---|
| inicial | Pantalla morada y dos pruebas de JuegoTest pendientes por TODO |
| hito1 | Lógica completa; pasan las cuatro pruebas de JuegoTest |
| hito2 | La interfaz responde, cambia de color y mide el tiempo |
| hito3 | Se muestra la plataforma y están los actual de Android, Desktop e iOS |
| solucion | Los cuatro hitos completos; el envío puede terminar en resultado local |

## Guardar antes de cambiar

```sh
git stash push -u -m "Mi avance"
git switch hito1
```

Usa hito1 para empezar el hito 2, hito2 para empezar el 3, hito3 para empezar el 4 o solucion para consultar el código completo. El avance guardado queda en `git stash list`. Vuelve a la rama donde lo guardaste antes de usar `git stash apply` y revisa cualquier conflicto.

## Archivos

- commonMain: Juego.kt, App.kt, Ranking.kt, Config.kt y Plataforma.kt desde el hito 3.
- commonTest: JuegoTest.kt.
- androidMain, jvmMain e iosMain: sus Plataforma*.kt desde el hito 3.
- Los Platform*.kt originales de la plantilla se conservan y no se modifican.
- `supabase.sql` crea solo `puntajes`, la tabla opcional de la aplicación de reflejos.

Todos los archivos usan el paquete mx.ibero.reflejos. Crea el actual de iOS también en Windows para completar la fuente; la ejecución y compilación de ese destino requieren Mac.

## Otras comprobaciones

Android host comprueba lógica en la computadora con `:shared:testAndroidHostTest`. No abre el emulador. En Apple Silicon, iOS Simulator usa `:shared:iosSimulatorArm64Test`. Ejecuta cada tarea con `./gradlew` en macOS o `.\gradlew.bat` en PowerShell.

`assembleDebug` solo genera la APK; para instalar y abrir Android usa Run del IDE. El récord vive mientras la app sigue abierta. Sin ranking, el tiempo y la posibilidad de repetir deben mantenerse.
