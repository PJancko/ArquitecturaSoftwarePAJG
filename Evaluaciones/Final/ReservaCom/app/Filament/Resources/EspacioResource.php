<?php

namespace App\Filament\Resources;

use App\Filament\Resources\EspacioResource\Pages;
use App\Filament\Resources\EspacioResource\RelationManagers;
use App\Models\Espacio;
use Filament\Forms;
use Filament\Forms\Form;
use Filament\Resources\Resource;
use Filament\Tables;
use Filament\Tables\Table;
use Illuminate\Database\Eloquent\Builder;
use Illuminate\Database\Eloquent\SoftDeletingScope;

class EspacioResource extends Resource
{
    protected static ?string $model = Espacio::class;

    protected static ?string $navigationIcon = 'heroicon-o-building-office';

    public static function form(Form $form): Form
    {
        return $form
            ->schema([
                Forms\Components\TextInput::make('nombre')->required(),
                Forms\Components\Textarea::make('descripcion'),
                Forms\Components\TextInput::make('capacidad_maxima')->numeric()->required(),
                Forms\Components\Textarea::make('reglas'),
                Forms\Components\Hidden::make('creado_por')
                    ->default(auth()->id()),
            ]);
    }

    public static function table(Table $table): Table
    {
        return $table
            ->columns([
                Tables\Columns\TextColumn::make('nombre')->searchable(),
                Tables\Columns\TextColumn::make('capacidad_maxima'),
                Tables\Columns\TextColumn::make('creador.name')->label('Creado por'),
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
            'index' => Pages\ListEspacios::route('/'),
            'create' => Pages\CreateEspacio::route('/create'),
            'edit' => Pages\EditEspacio::route('/{record}/edit'),
        ];
    }
    public static function canAccess(): bool
    {
        return in_array(auth()->user()->rol, ['admin', 'encargado']);
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
