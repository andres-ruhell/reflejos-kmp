# Ranking opcional de ¿Dónde va?

El juego funciona sin este servicio. Una sola persona configura el ranking para todo el grupo.

1. Crea un proyecto Supabase de aula y ejecuta `supabase.sql` de esta carpeta. Este script crea únicamente la tabla `donde_va` del juego de preguntas; no es la tabla de tiempos de Reflejos.
2. Copia Project URL y una llave publishable desde la sección de API. Nunca uses la contraseña de la base, service_role o sb_secret_.
3. En `donde-va.html` llena las constantes `SUPABASE_URL` y `SUPABASE_KEY` al inicio del script y vuelve a publicar el HTML. También puedes indicar `url` y `key` como parámetros de la dirección, usando solo la llave pública.
4. Completa una partida de Clase y comprueba su fila en `donde_va`. Para proyectar el ranking abre la misma página con `?tablero` al final; si ya usas parámetros agrega `&tablero`.

Los resultados se consultan periódicamente; no se necesita Realtime. Repaso no envía puntajes. La modalidad local sigue disponible si falla el servicio. Los datos vienen del navegador y no se validan contra trampas: usa apodos y resultados didácticos.

Referencia: [Data API de Supabase](https://supabase.com/docs/guides/api) y [llaves de API](https://supabase.com/docs/guides/api/api-keys).
