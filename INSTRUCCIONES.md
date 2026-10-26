# Juego de preguntas ¿Dónde va?

Actividad de repaso de Kotlin Multiplatform para jugar en el navegador. Usa ejemplos de lógica, interfaz, plataformas y red de Reflejos KMP, pero se abre por separado y no modifica el proyecto de la minipráctica.

## Abrir

- En computadora o celular, abre [¿Dónde va?](https://andres-ruhell.github.io/reflejos-kmp/donde-va.html). También puedes escanear `QR_Donde_Va.png`.
- Para usarlo sin conexión en una computadora, descarga esta carpeta y abre `donde-va.html` con tu navegador. Una ruta de archivo local no sirve como enlace para los celulares de otras personas.
- No se requiere Android Studio, Git ni una cuenta para jugar. La primera apertura del enlace publicado sí necesita internet.

## Jugar

1. Escribe un nombre o apodo.
2. Elige **Clase** para una partida corta de 12 preguntas, tres por ronda, con 20 segundos para responder cada una. Elige **Repaso** para recorrer las 28 preguntas sin reloj; es la opción más cómoda para aprender por primera vez.
3. Pulsa Empezar y elige una respuesta. Después lee la explicación: no hay límite de tiempo para leerla. Pulsa Siguiente para continuar.
4. Al final verás aciertos y puntos. Si hubo errores, abre Repasar respuestas para ver la solución y el archivo relacionado. Pulsa Volver al inicio para repetir.

Hay cuatro rondas: carpeta o source set, si el fragmento compila, ubicación de dependencias y comportamiento del código. En expect/actual se supone que los imports, el paquete y las implementaciones de los demás destinos están completos, salvo que la pregunta indique lo contrario.

Cada acierto suma 100 puntos. En Clase se agrega un bono por rapidez de hasta 50 puntos y por racha de hasta 50; una respuesta incorrecta o sin contestar no suma y reinicia la racha. En Repaso cada acierto vale 100 puntos, sin bonos. Compara puntajes únicamente dentro de la misma modalidad.

El juego funciona con resultado local. El ranking compartido es opcional y solo recibe partidas de Clase. Su preparación está separada en `Ranking_opcional.md`; Repaso nunca envía resultados.
