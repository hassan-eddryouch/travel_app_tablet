package com.example.travel_app

data class Flight(
    val airlineName: String,
    val departureCode: String,
    val departureTime: String,
    val arrivalCode: String,
    val arrivalTime: String,
    val duration: String,
    val price: String,
    val meal: String
)