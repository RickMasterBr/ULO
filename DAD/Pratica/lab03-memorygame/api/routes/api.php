<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

Route::get('/user', function (Request $request) {
    return $request->user();
})->middleware('auth:sanctum');

Route::get('metadata', function (Request $request) {
    //abort(500, 'Something went wrong');
    return [
        "name" => "DAD Worksheet API",
        "version" => "0.0.1"
    ];
});
