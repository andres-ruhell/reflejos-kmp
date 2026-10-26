-- Ranking en vivo para la clase de Kotlin Multiplatform.
-- Pégalo en Supabase → SQL Editor → Run.

-- Tiempos de la práctica "Reflejos KMP"
create table if not exists public.puntajes (
  id bigint generated always as identity primary key,
  nombre text not null check (char_length(nombre) between 1 and 30),
  ms integer not null check (ms between 80 and 5000),
  plataforma text not null check (char_length(plataforma) between 1 and 60),
  creado timestamptz not null default now()
);

-- Puntos del juego final "¿Dónde va?"
create table if not exists public.donde_va (
  id bigint generated always as identity primary key,
  nombre text not null check (char_length(nombre) between 1 and 30),
  puntos integer not null check (puntos between 0 and 10000),
  aciertos integer not null check (aciertos between 0 and 100),
  creado timestamptz not null default now()
);

-- Demo de aula: la llave pública permite leer e insertar datos de prueba.
-- El cliente puede falsificar tiempos: no es una competencia con premios ni un benchmark.
-- Las políticas son repetibles si vuelves a ejecutar el script.
alter table public.puntajes enable row level security;
alter table public.donde_va enable row level security;

drop policy if exists "insertar" on public.puntajes;
drop policy if exists "leer" on public.puntajes;
drop policy if exists "insertar" on public.donde_va;
drop policy if exists "leer" on public.donde_va;

create policy "insertar" on public.puntajes for insert to anon with check (true);
create policy "leer" on public.puntajes for select to anon using (true);
create policy "insertar" on public.donde_va for insert to anon with check (true);
create policy "leer" on public.donde_va for select to anon using (true);

revoke all on public.puntajes, public.donde_va from anon, authenticated;
grant usage on schema public to anon;
grant select, insert on public.puntajes to anon;
grant select, insert on public.donde_va to anon;

-- Después de la clase, para limpiar:
--   drop table public.puntajes;
--   drop table public.donde_va;
