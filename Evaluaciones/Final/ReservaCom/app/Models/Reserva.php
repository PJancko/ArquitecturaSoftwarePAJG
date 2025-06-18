<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Reserva extends Model
{
    /** @use HasFactory<\Database\Factories\ReservaFactory> */
    use HasFactory;
    protected $fillable = [
        'espacio_id',
        'usuario_id',
        'fecha',
        'hora_inicio',
        'hora_fin',
        'estado',
    ];
    public function usuario()
    {
        return $this->belongsTo(User::class, 'usuario_id');
    }
    public function espacio()
    {
        return $this->belongsTo(Espacio::class);
    }
    public function incidencias()
    {
        return $this->hasMany(Incidencia::class);
    }
}
