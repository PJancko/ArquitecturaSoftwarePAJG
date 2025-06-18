<?php

namespace App\Filament\Resources\HorariosEspacioResource\Pages;

use App\Filament\Resources\HorariosEspacioResource;
use Filament\Actions;
use Filament\Resources\Pages\EditRecord;

class EditHorariosEspacio extends EditRecord
{
    protected static string $resource = HorariosEspacioResource::class;

    protected function getHeaderActions(): array
    {
        return [
            Actions\DeleteAction::make(),
        ];
    }
}
