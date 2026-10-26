# Ranking opcional de Reflejos KMP

La aplicación funciona y la minipráctica se completa sin este servicio. Estos pasos solo se usan si el grupo quiere compartir los tiempos. Una sola persona prepara el proyecto; los alumnos reciben su URL y llave pública.

1. En Supabase crea un proyecto Free de aula y conserva su contraseña de base de datos fuera del código. No necesitas activar Realtime.
2. En SQL Editor ejecuta `supabase.sql` de esta carpeta. Solo crea la tabla `puntajes` del juego de reflejos y permite lectura e inserción con el rol anon.
3. En la sección de API del proyecto copia Project URL y la llave publishable. En `Config.kt` coloca esos datos en `SUPABASE_URL` y `SUPABASE_KEY`. Conserva el nombre o apodo de cada participante.
4. Abre `tablero.html`, pulsa Configurar y escribe la misma URL y llave pública. Para proyectarlo desde otra computadora puede usarse la [página del tablero](https://andres-ruhell.github.io/reflejos-kmp/practica/tablero.html).
5. Completa una ronda de 80 a 5000 ms. Comprueba que la app muestre En el ranking y que el registro aparezca en la tabla y en el tablero. Fuera de ese rango el envío se rechaza y el tiempo permanece local.

La contraseña de la base, service_role y las llaves sb_secret_ nunca van en Config.kt, HTML o GitHub. Si aparece No enviado: resultado local, revisa URL, llave, permisos, conexión y rango del tiempo.

Nueva ronda filtra las jugadas desde ese instante, sin borrarlas. El cliente puede enviar tiempos inventados; es una demostración de red, no una medición de rendimiento entre plataformas ni una evaluación con premios.

Referencia: [Data API de Supabase](https://supabase.com/docs/guides/api) y [llaves de API](https://supabase.com/docs/guides/api/api-keys).
