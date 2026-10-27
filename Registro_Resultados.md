# Registro de ejecución de Reflejos KMP

Nombre o equipo:

Fecha:

Sistema operativo y versión:

Versión de Android Studio:

Dispositivo Android y API:

Simulador iOS, si aplica:

Usa Correcto, Fallo o No aplica. Adjunta las capturas en una carpeta y anota sus nombres en la última columna.

| Comprobación | Desktop | Android | iOS opcional | Evidencia u observación |
|---|---|---|---|---|
| Abre la pantalla inicial y muestra su plataforma | | | | |
| Inicia una ronda roja | | | | |
| Cambia a verde después de la espera | | | | |
| Muestra el tiempo al tocar en verde | | | | |
| Detecta una falta al tocar en rojo | | | | |
| Conserva el mejor tiempo durante la sesión | | | | |
| Permite repetir después del resultado o falta | | | | |
| Conserva el tiempo local aunque no se guarde el envío | | | | |

| Pruebas automáticas | Resultado | Evidencia |
|---|---|---|
| JuegoTest en JVM, cuatro casos correctos | | |
| JuegoTest en Android host, cuatro casos correctos | | |
| JuegoTest en iOS Simulator, opcional | | |
| Compilación Android con assembleDebug | | |
| Envío al ranking, solo si está configurado | | |

## Relación con el código

1. ¿Qué archivos usan en común Desktop, Android e iOS?

2. ¿Qué cambia con expect y actual al mostrar la plataforma?

3. ¿Qué sucede si el resultado no se guarda en el ranking?

## Fallos encontrados

Para cada fallo, indica la plataforma, el paso para reproducirlo y el mensaje exacto. Si no hubo fallos, indícalo. No marques como correcta una comprobación que no realizaste.
