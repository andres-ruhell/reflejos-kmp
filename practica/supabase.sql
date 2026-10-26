-- Reflejos KMP: ranking opcional de tiempos de reacción.
-- Ejecutar en SQL Editor de un proyecto Supabase de aula.
create table if not exists public.puntajes (
  id bigint generated always as identity primary key,
  nombre text not null check (char_length(nombre) between 1 and 30),
  ms integer not null check (ms between 80 and 5000),
  plataforma text not null check (char_length(plataforma) between 1 and 60),
  creado timestamptz not null default now()
);
alter table public.puntajes enable row level security;
drop policy if exists "insertar" on public.puntajes;
drop policy if exists "leer" on public.puntajes;
create policy "insertar" on public.puntajes for insert to anon with check (true);
create policy "leer" on public.puntajes for select to anon using (true);
revoke all on public.puntajes from anon, authenticated;
grant usage on schema public to anon;
grant select, insert on public.puntajes to anon;
-- Uso didáctico con apodos. El cliente puede inventar tiempos.
