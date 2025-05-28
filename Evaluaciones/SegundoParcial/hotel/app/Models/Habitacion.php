<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Habitacion extends Model
{
    /** @use HasFactory<\Database\Factories\HabitacionFactory> */
    use HasFactory;
    protected $fillable = [
        'numero_habitacion',
        'tipo_habitacion_id',
        'precio_por_noche',
        'estado',
        'descripcion',
    ];

    public function tipoHabitacion()
    {
        return $this->belongsTo(Tipos_habitacion::class, 'tipo_habitacion_id');
    }
}
