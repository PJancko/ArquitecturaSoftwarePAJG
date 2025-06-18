<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Espacio extends Model
{
    /** @use HasFactory<\Database\Factories\EspacioFactory> */
    use HasFactory;
    protected $fillable = [
        'nombre',
        'descripcion',
        'capacidad_maxima',
        'reglas',
        'creado_por',
    ];
    public function creador()
    {
        return $this->belongsTo(User::class, 'creado_por');
    }
    public function horarios()
    {
        return $this->hasMany(HorariosEspacio::class);
    }
    public function reservas()
    {
        return $this->hasMany(Reserva::class);
    }
}
