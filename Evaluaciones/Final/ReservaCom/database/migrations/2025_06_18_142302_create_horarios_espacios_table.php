<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('horarios_espacios', function (Blueprint $table) {
            $table->id();
            $table->foreignId('espacio_id')->constrained('espacios')->onDelete('cascade');
            $table->tinyInteger('dia_semana'); // 0: Domingo, 1: Lunes, ..., 6: Sábado
            $table->time('hora_inicio');
            $table->time('hora_fin');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('horarios_espacios');
    }
};
