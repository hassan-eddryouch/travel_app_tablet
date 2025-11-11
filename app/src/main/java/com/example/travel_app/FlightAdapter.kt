package com.example.travel_app

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FlightAdapter(
    private val flights: List<Flight>
    // SUPPRIMÉ : ViewModel n'est plus passé ici
    // private val viewModel: FlightViewModel
) : RecyclerView.Adapter<FlightAdapter.FlightViewHolder>() {

    inner class FlightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvAirlineName: TextView = itemView.findViewById(R.id.tvAirlineName)
        val tvDepartureCode: TextView = itemView.findViewById(R.id.tvDepartureCode)
        val tvDepartureTime: TextView = itemView.findViewById(R.id.tvDepartureTime)
        val tvArrivalCode: TextView = itemView.findViewById(R.id.tvArrivalCode)
        val tvArrivalTime: TextView = itemView.findViewById(R.id.tvArrivalTime)
        val tvDuration: TextView = itemView.findViewById(R.id.tvDuration)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val tvMeal: TextView = itemView.findViewById(R.id.tvMeal)
        val imgPriceTag: ImageView = itemView.findViewById(R.id.imgPriceTag)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fight, parent, false)
        return FlightViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        val flight = flights[position]
        holder.tvAirlineName.text = flight.airlineName
        holder.tvDepartureCode.text = flight.departureCode
        holder.tvDepartureTime.text = flight.departureTime
        holder.tvArrivalCode.text = flight.arrivalCode
        holder.tvArrivalTime.text = flight.arrivalTime
        holder.tvDuration.text = flight.duration
        holder.tvPrice.text = flight.price
        holder.tvMeal.text = flight.meal
        holder.imgPriceTag.setImageResource(R.drawable.ic_rupee)

    }

    override fun getItemCount(): Int = flights.size
}