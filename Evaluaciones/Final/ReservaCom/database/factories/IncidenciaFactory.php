<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;
use App\Models\Reserva;
use App\Models\User;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Incidencia>
 */
class IncidenciaFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'reserva_id' => Reserva::inRandomOrder()->first()->id ?? Reserva::factory(),
            'reportado_por' => User::where('rol', 'residente')->inRandomOrder()->first()->id ?? User::factory(),
            'descripcion' => $this->faker->paragraph(),
            'gravedad' => $this->faker->randomElement(['leve', 'moderado', 'grave']),
        ];
    }
}
