<?php
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\AuthController;
use App\Http\Controllers\GameController;
use App\Http\Controllers\UserController;

Route::post('/login', [AuthController::class, 'login']);

Route::middleware('auth:sanctum')->group(function () {
    Route::get('/users/me', function (Request $request) {
        return $request->user();
    });
    Route::post('logout', [AuthController::class, 'logout']);
});

Route::apiResources([
    'games' => GameController::class
]);

Route::apiResources([
    'users' => UserController::class
]);

Route::get('metadata', function () {
    return [
        "name" => "DAD Worksheet API",
        "version" => "0.0.1"
    ];
});
