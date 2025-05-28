<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\Tipos_habitacion;

class TiposHabitacionSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $tipos = [
            ['nombre' => 'Simple', 'descripcion' => 'Habitación simple para una persona', 'precio' => 100],
            ['nombre' => 'Doble', 'descripcion' => 'Habitación doble para dos personas', 'precio' => 180],
            ['nombre' => 'Triple', 'descripcion' => 'Habitación para tres personas', 'precio' => 250],
            ['nombre' => 'Matrimonio', 'descripcion' => 'Habitación matrimonial', 'precio' => 220],
        ];

        foreach($tipos as $tipo){
            Tipos_habitacion::create($tipo);
        }
    }
}
