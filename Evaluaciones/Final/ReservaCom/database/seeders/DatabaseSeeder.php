<?php

namespace Database\Seeders;

use App\Models\User;
// use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\HorariosEspacio;
use App\Models\Reserva;
use App\Models\Incidencia;
use App\Models\Espacio;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     */
    public function run(): void
    {
        // User::factory(10)->create();

        User::factory()->create([
            'name' => 'Test User1',
            'email' => 'admin@example.com',
            'rol' => 'admin',
            'password' => bcrypt('password'),
        ]);
        User::factory()->create([
            'name' => 'Test User2',
            'email' => 'encargado@example.com',
            'rol' => 'encargado',
            'password' => bcrypt('password'),
        ]);
        User::factory()->create([
            'name' => 'Test User3',
            'email' => 'residente@example.com',
            'rol' => 'residente',
            'password' => bcrypt('password'),
        ]);
        // Crear encargados y residentes
        User::factory(3)->create(['rol' => 'encargado']);
        User::factory(10)->create(['rol' => 'residente']);

        // Crear espacios
        Espacio::factory(5)->create()->each(function ($espacio) {
            // Crear horarios para cada espacio
            foreach (range(1, 5) as $dia) {
                HorariosEspacio::factory()->create([
                    'espacio_id' => $espacio->id,
                    'dia_semana' => $dia,
                ]);
            }
        });

        // Crear reservas y algunas incidencias
        Reserva::factory(30)->create();
        Incidencia::factory(10)->create();
    }
}
