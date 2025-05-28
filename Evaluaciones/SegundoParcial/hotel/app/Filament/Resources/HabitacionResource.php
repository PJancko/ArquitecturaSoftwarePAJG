<?php

namespace App\Filament\Resources;

use App\Filament\Resources\HabitacionResource\Pages;
use App\Filament\Resources\HabitacionResource\RelationManagers;
use App\Models\Habitacion;
use Filament\Forms;
use Filament\Forms\Form;
use Filament\Resources\Resource;
use Filament\Tables;
use Filament\Tables\Table;
use Illuminate\Database\Eloquent\Builder;
use Illuminate\Database\Eloquent\SoftDeletingScope;
use App\Models\Tipos_habitacion;
use Filament\Forms\Components\TextInput;
use Filament\Forms\Components\Select;
use Filament\Forms\Components\Textarea;
use Filament\Tables\Columns\TextColumn;

class HabitacionResource extends Resource
{
    protected static ?string $model = Habitacion::class;

    protected static ?string $navigationIcon = 'heroicon-o-rectangle-stack';
    protected static ?string $navigationLabel = 'Habitaciones';
    protected static ?string $modelLabel = 'Habitación';

    public static function form(Form $form): Form
    {
        return $form
            ->schema([
                TextInput::make('numero_habitacion')
                    ->required()
                    ->unique(ignoreRecord: true),

                Select::make('tipo_habitacion_id')
                    ->label('Tipo de habitación')
                    ->relationship('tipoHabitacion', 'nombre')
                    ->required(),

                TextInput::make('precio_por_noche')
                    ->numeric()
                    ->required()
                    ->prefix('Bs'),

                Select::make('estado')
                    ->options([
                        'disponible' => 'Disponible',
                        'ocupada' => 'Ocupada',
                        'mantenimiento' => 'Mantenimiento',
                    ])
                    ->required(),

                Textarea::make('descripcion')
                    ->rows(3)
                    ->required(),
            ]);
    }

    public static function table(Table $table): Table
    {
        return $table
            ->columns([
                TextColumn::make('numero_habitacion')->sortable()->searchable(),
                TextColumn::make('tipoHabitacion.nombre')->label('Tipo'),
                TextColumn::make('precio_por_noche')->money('BOB', true),
                TextColumn::make('estado')->badge(),
            ])
            ->filters([
                //
            ]);
    }

    public static function getRelations(): array
    {
        return [
            //
        ];
    }

    public static function getPages(): array
    {
        return [
            'index' => Pages\ListHabitacions::route('/'),
            'create' => Pages\CreateHabitacion::route('/create'),
            'edit' => Pages\EditHabitacion::route('/{record}/edit'),
        ];
    }
}
