<?php

namespace App\Filament\Resources;

use App\Filament\Resources\ReservaResource\Pages;
use App\Filament\Resources\ReservaResource\RelationManagers;
use App\Models\Reserva;
use Filament\Forms;
use Filament\Forms\Form;
use Filament\Resources\Resource;
use Filament\Tables;
use Filament\Tables\Table;
use Illuminate\Database\Eloquent\Builder;
use Illuminate\Database\Eloquent\SoftDeletingScope;

class ReservaResource extends Resource
{
    protected static ?string $model = Reserva::class;

    protected static ?string $navigationIcon = 'heroicon-o-calendar';

    public static function form(Form $form): Form
    {
        return $form
            ->schema([
                Forms\Components\Select::make('user_id')->relationship('usuario', 'name')->required(),
                Forms\Components\Select::make('espacio_id')->relationship('espacio', 'nombre')->required(),
                Forms\Components\DatePicker::make('fecha_reserva')->required(),
                Forms\Components\TimePicker::make('hora_inicio')->required(),
                Forms\Components\TimePicker::make('hora_fin')->required(),
                Forms\Components\Hidden::make('estado')
                    ->default('pendiente')

            ]);
    }

    public static function table(Table $table): Table
    {
        return $table
            ->columns([
                Tables\Columns\TextColumn::make('usuario.name')->label('Usuario')->searchable(),
                Tables\Columns\TextColumn::make('espacio.nombre')->label('Espacio')->searchable(),
                Tables\Columns\TextColumn::make('fecha_reserva')->date()->label('Fecha'),
                Tables\Columns\TextColumn::make('hora_inicio')->time()->label('Hora Inicio'),
                Tables\Columns\TextColumn::make('hora_fin')->time()->label('Hora Fin'),
                Tables\Columns\TextColumn::make('estado')
                    ->label('Estado')
                    ->formatStateUsing(function ($state) {
                        return [
                            'pendiente' => 'Pendiente',
                            'aprobado' => 'Aprobado',
                            'rechazado' => 'Rechazado',
                            'cancelado' => 'Cancelado',
                        ][$state] ?? $state;
                    }),
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
            'index' => Pages\ListReservas::route('/'),
            'create' => Pages\CreateReserva::route('/create'),
            'edit' => Pages\EditReserva::route('/{record}/edit'),
        ];
    }
    public static function canAccess(): bool
    {
        return in_array(auth()->user()->rol, ['admin', 'encargado', 'residente']);
    }
    public static function canCreate(): bool
    {
        return in_array(auth()->user()->rol, ['admin', 'encargado', 'residente']);
    }
    public static function canEdit(\Illuminate\Database\Eloquent\Model $record): bool
    {
        return in_array(auth()->user()->rol, ['admin', 'encargado']) || (auth()->user()->rol === 'residente' && $record->user_id === auth()->id());
    }
    public static function canDelete(\Illuminate\Database\Eloquent\Model $record): bool
    {
        return in_array(auth()->user()->rol, ['admin', 'encargado']) || (auth()->user()->rol === 'residente' && $record->user_id === auth()->id());
    }

}
