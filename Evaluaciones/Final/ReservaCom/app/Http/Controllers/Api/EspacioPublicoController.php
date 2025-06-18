<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Espacio;

class EspacioPublicoController extends Controller
{
    public function index()
    {
        $espacios = Espacio::select('id', 'nombre', 'descripcion', 'capacidad_maxima', 'reglas')
            ->get();

        return response()->json([
            'success' => true,
            'data' => $espacios,
        ]);
    }
}
