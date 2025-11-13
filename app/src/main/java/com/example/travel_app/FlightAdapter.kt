package com.example.travel_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.travel_app.databinding.ItemFightBinding

class FlightsAdapter(
    private val flights: List<Flight>,
    private val listener: OnFlightClickListener
) : RecyclerView.Adapter<FlightsAdapter.ViewHolder>() {

    interface OnFlightClickListener {
        fun onFlightClick(flight: Flight)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFightBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val flight = flights[position]
        holder.bind(flight)
    }

    override fun getItemCount() = flights.size

    inner class ViewHolder(private val binding: ItemFightBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onFlightClick(flights[position])
                }
            }
        }

        fun bind(flight: Flight) {
            binding.ivAirlineIcon?.setImageResource(flight.airlineIconResId)
            binding.tvAirlineName.text = flight.airlineName
            binding.tvDepartureCode.text = flight.departureCode
            binding.tvDepartureTime.text = flight.departureTime
            binding.tvArrivalCode.text = flight.arrivalCode
            binding.tvArrivalTime.text = flight.arrivalTime
            binding.tvDuration.text = flight.duration
            binding.tvPrice.text = flight.price
            binding.tvMeal.text = flight.mealInfo
        }
    }
}