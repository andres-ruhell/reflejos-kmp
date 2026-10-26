-- ¿Dónde va?: ranking opcional del juego de preguntas.
-- Ejecutar en SQL Editor de un proyecto Supabase de aula.
create table if not exists public.donde_va (
  id bigint generated always as identity primary key,
  nombre text not null check (char_length(nombre) between 1 and 30),
  puntos integer not null check (puntos between 0 and 10000),
  aciertos integer not null check (aciertos between 0 and 12),
  creado timestamptz not null default now()
);
alter table public.donde_va enable row level security;
drop policy if exists "insertar" on public.donde_va;
drop policy if exists "leer" on public.donde_va;
create policy "insertar" on public.donde_va for insert to anon with check (true);
create policy "leer" on public.donde_va for select to anon using (true);
revoke all on public.donde_va from anon, authenticated;
grant usage on schema public to anon;
grant select, insert on public.donde_va to anon;
-- Uso didáctico con apodos. No hay validación contra trampas.
