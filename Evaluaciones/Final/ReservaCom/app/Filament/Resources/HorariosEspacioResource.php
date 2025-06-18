<?php

namespace App\Filament\Resources;

use App\Filament\Resources\HorariosEspacioResource\Pages;
use App\Filament\Resources\HorariosEspacioResource\RelationManagers;
use App\Models\HorariosEspacio;
use Filament\Forms;
use Filament\Forms\Form;
use Filament\Resources\Resource;
use Filament\Tables;
use Filament\Tables\Table;
use Illuminate\Database\Eloquent\Builder;
use Illuminate\Database\Eloquent\SoftDeletingScope;

class HorariosEspacioResource extends Resource
{
    protected static ?string $model = HorariosEspacio::class;

    protected static ?string $navigationIcon = 'heroicon-o-clock';

    public static function form(Form $form): Form
    {
        return $form
            ->schema([
                Forms\Components\Select::make('dia_semana')
                    ->required()
                    ->label('Día de la semana')
                    ->options([
                        0 => 'Domingo',
                        1 => 'Lunes',
                        2 => 'Martes',
                        3 => 'Miércoles',
                        4 => 'Jueves',
                        5 => 'Viernes',
                        6 => 'Sábado',
                    ]),
                Forms\Components\TextInput::make('hora_inicio')
                    ->required()
                    ->label('Hora de inicio'),
                Forms\Components\TextInput::make('hora_fin')
                    ->required()
                    ->label('Hora de fin'),
                Forms\Components\Select::make('espacio_id')
                    ->relationship('espacio', 'nombre')
                    ->required()
                    ->label('Espacio'),
            ]);
    }

    public static function table(Table $table): Table
    {
        return $table
            ->columns([
                Tables\Columns\TextColumn::make('dia_semana')
                    ->searchable()
                    ->label('Día de la semana')
                    ->formatStateUsing(function ($state) {
                        $dias = [
                            0 => 'Domingo',
                            1 => 'Lunes',
                            2 => 'Martes',
                            3 => 'Miércoles',
                            4 => 'Jueves',
                            5 => 'Viernes',
                            6 => 'Sábado',
                        ];
                        return $dias[$state] ?? $state;
                    }),
                Tables\Columns\TextColumn::make('hora_inicio')
                    ->label('Hora de inicio'),
                Tables\Columns\TextColumn::make('hora_fin')
                    ->label('Hora de fin'),
                Tables\Columns\TextColumn::make('espacio.nombre')
                    ->label('Espacio'),
            ])
            ->filters([
                //
            ])
            ->actions([
                Tables\Actions\EditAction::make(),
                Tables\Actions\DeleteAction::make(),
            ])
            ->bulkActions([
                Tables\Actions\BulkActionGroup::make([
                    Tables\Actions\DeleteBulkAction::make(),
                ]),
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
            'index' => Pages\ListHorariosEspacios::route('/'),
            'create' => Pages\CreateHorariosEspacio::route('/create'),
            'edit' => Pages\EditHorariosEspacio::route('/{record}/edit'),
        ];
    }
    public static function canCreate(): bool
    {
        return auth()->user()->rol !== 'residente' && auth()->user()->rol !== 'encargado';
    }
    public static function canEdit(\Illuminate\Database\Eloquent\Model $record): bool
    {
        return auth()->user()->rol !== 'residente' && auth()->user()->rol !== 'encargado';
    }
    public static function canDelete(\Illuminate\Database\Eloquent\Model $record): bool
    {
        return auth()->user()->rol !== 'residente' && auth()->user()->rol !== 'encargado';
    }
}
