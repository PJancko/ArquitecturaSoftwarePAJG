<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Tipos_habitacion extends Model
{
    /** @use HasFactory<\Database\Factories\TiposHabitacionFactory> */
    use HasFactory;
    protected $fillable = [
        'nombre',
        'descripcion',
        'capacidad',
        'precio_base',
    ];
    public function habitaciones()
    {
        return $this->hasMany(Habitacion::class, 'tipo_habitacion_id');
    }
}
