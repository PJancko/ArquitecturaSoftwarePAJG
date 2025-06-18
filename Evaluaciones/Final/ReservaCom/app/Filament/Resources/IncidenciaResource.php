<?php

namespace App\Filament\Resources;

use App\Filament\Resources\IncidenciaResource\Pages;
use App\Filament\Resources\IncidenciaResource\RelationManagers;
use App\Models\Incidencia;
use Filament\Forms;
use Filament\Forms\Form;
use Filament\Resources\Resource;
use Filament\Tables;
use Filament\Tables\Table;
use Illuminate\Database\Eloquent\Builder;
use Illuminate\Database\Eloquent\SoftDeletingScope;

class IncidenciaResource extends Resource
{
    protected static ?string $model = Incidencia::class;

    protected static ?string $navigationIcon = 'heroicon-o-exclamation-triangle';

    public static function form(Form $form): Form
    {
        return $form
            ->schema([
                Forms\Components\Select::make('reserva_id')
                    ->relationship('reserva', 'id')
                    ->label('Reserva')
                    ->required(),

                Forms\Components\Select::make('reportado_por')
                    ->relationship('reportadoPor', 'name')
                    ->label('Encargado')
                    ->required(),

                Forms\Components\Textarea::make('descripcion')
                    ->label('Descripción')
                    ->rows(4)
                    ->required(),

                Forms\Components\Select::make('gravedad')
                    ->label('Gravedad')
                    ->options([
                        'leve' => 'Leve',
                        'moderado' => 'Moderado',
                        'grave' => 'Grave',
                    ])
                    ->required(),
            ]);
    }

    public static function table(Table $table): Table
    {
        return $table
            ->columns([
                Tables\Columns\TextColumn::make('reserva.id')->label('Reserva'),
                Tables\Columns\TextColumn::make('reportadoPor.name')->label('Reportado por'),
                Tables\Columns\TextColumn::make('gravedad')->sortable(),
                Tables\Columns\TextColumn::make('descripcion')->limit(50),
                Tables\Columns\TextColumn::make('created_at')->label('Fecha de reporte')->dateTime(),
            ])
            ->filters([
                //
            ])
            ->actions([
                Tables\Actions\EditAction::make(),
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
            'index' => Pages\ListIncidencias::route('/'),
            'create' => Pages\CreateIncidencia::route('/create'),
            'edit' => Pages\EditIncidencia::route('/{record}/edit'),
        ];
    }
    public static function canAccess(): bool
    {
        return in_array(auth()->user()->rol, ['admin', 'encargado']);
    }

}
