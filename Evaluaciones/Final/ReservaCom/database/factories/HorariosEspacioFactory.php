<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;
use App\Models\Espacio;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\HorariosEspacio>
 */
class HorariosEspacioFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'espacio_id' => Espacio::inRandomOrder()->first()->id ?? Espacio::factory(),
            'dia_semana' => $this->faker->numberBetween(0, 6), // 0 = Domingo, 6 = Sábado
            'hora_inicio' => $this->faker->time('H:i', '18:00'),
            'hora_fin' => $this->faker->time('H:i', '22:00'),
        ];
    }
}
