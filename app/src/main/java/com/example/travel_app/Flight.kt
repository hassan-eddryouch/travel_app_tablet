package com.example.travel_app

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize
@Parcelize
data class Flight(
    val airlineName: String,
    @DrawableRes val airlineIconResId: Int,
    val departureCode: String,
    val departureTime: String,
    val arrivalCode: String,
    val arrivalTime: String,
    val duration: String,
    val price: String,
    val mealInfo: String,
    val boardingTime: String
) : Parcelable