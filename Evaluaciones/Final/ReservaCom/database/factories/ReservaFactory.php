<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;
use App\Models\User;
use App\Models\Espacio;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Reserva>
 */
class ReservaFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'usuario_id' => User::where('rol', 'residente')->inRandomOrder()->first()->id ?? User::factory(),
            'espacio_id' => Espacio::inRandomOrder()->first()->id ?? Espacio::factory(),
            'fecha_reserva' => $this->faker->dateTimeBetween('now', '+1 month')->format('Y-m-d'),
            'hora_inicio' => $this->faker->time('H:i'),
            'hora_fin' => $this->faker->time('H:i'),
            'estado' => $this->faker->randomElement(['pendiente', 'aprobado', 'rechazado', 'cancelada']),
        ];
    }
}
