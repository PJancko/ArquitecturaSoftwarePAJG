<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;
use App\Models\User;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Espacio>
 */
class EspacioFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'nombre' => $this->faker->word(),
            'descripcion' => $this->faker->sentence(),
            'capacidad_maxima' => $this->faker->numberBetween(5, 50),
            'reglas' => $this->faker->paragraph(),
            'creado_por' => User::inRandomOrder()->first()->id ?? User::factory(), 
        ];
    }
}
