<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\Tipos_habitacion;
use App\Models\Habitacion;

class HabitacionSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $tipos = Tipos_habitacion::pluck('id', 'nombre');

        $contador = 1;

        $habitaciones = array_merge(
            $this->generarHabitaciones('Simple', 10, $contador, $tipos),
            $this->generarHabitaciones('Doble', 5, $contador, $tipos),
            $this->generarHabitaciones('Triple', 5, $contador, $tipos),
            $this->generarHabitaciones('Matrimonio', 8, $contador, $tipos),
        );

        Habitacion::insert($habitaciones);
    }
    private function generarHabitaciones(string $tipo, int $cantidad, int &$contador, $tipos): array
    {
        $resultado = [];

        for ($i = 0; $i < $cantidad; $i++) {
            $resultado[] = [
                'numero_habitacion' => 'H' . str_pad($contador++, 3, '0', STR_PAD_LEFT),
                'tipo_habitacion_id' => $tipos[$tipo],
                'precio_por_noche' => $tipos[$tipo] * 1.0,
                'estado' => 'disponible',
                'descripcion' => "Habitación tipo $tipo",
                'created_at' => now(),
                'updated_at' => now(),
            ];
        }

        return $resultado;
    }
}
