<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Incidencia extends Model
{
    /** @use HasFactory<\Database\Factories\IncidenciaFactory> */
    use HasFactory;
    protected $fillable = [
        'reserva_id',
        'reportado_por',
        'descripcion',
        'gravedad',
    ];
    public function reserva()
    {
        return $this->belongsTo(Reserva::class);
    }
    public function reportadoPor()
    {
        return $this->belongsTo(User::class, 'reportado_por');
    }
}
