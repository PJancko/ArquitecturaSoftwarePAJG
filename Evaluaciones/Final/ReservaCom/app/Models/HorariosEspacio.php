<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class HorariosEspacio extends Model
{
    /** @use HasFactory<\Database\Factories\HorariosEspacioFactory> */
    use HasFactory;
    protected $fillable = [
        'espacio_id',
        'dia_semana',
        'hora_inicio',
        'hora_fin',
    ];
    public function espacio()
    {
        return $this->belongsTo(Espacio::class);
    }
}
