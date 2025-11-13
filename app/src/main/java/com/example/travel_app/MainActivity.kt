package com.example.travel_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travel_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FlightsAdapter.OnFlightClickListener {


    private lateinit var binding: ActivityMainBinding
    private lateinit var flightsAdapter: FlightsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        val dummyFlights = createDummyData()

        flightsAdapter = FlightsAdapter(dummyFlights, this)

        binding.recyclerFlights.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = flightsAdapter
        }
    }


    override fun onFlightClick(flight: Flight) {
        val detailFragment = FlightDetailFragment.newInstance(flight)

        supportFragmentManager.beginTransaction()
            .replace(R.id.detail_fragment_container, detailFragment)
            .commit()
    }

    private fun createDummyData(): List<Flight> {
        return listOf(
            Flight(
                airlineName = "Indigo",
                airlineIconResId = R.drawable.ic_indigo,
                departureCode = "DEL",
                departureTime = "06:30",
                arrivalCode = "BLR",
                arrivalTime = "10:45",
                duration = "04h 15m",
                price = "7,319",
                mealInfo = "Free Meal",
                boardingTime = "06:00 AM"
            ),
            Flight(
                airlineName = "Vistara",
                airlineIconResId = R.drawable.ic_indigo,
                departureCode = "DEL",
                departureTime = "07:00",
                arrivalCode = "BLR",
                arrivalTime = "11:30",
                duration = "04h 30m",
                price = "8,120",
                mealInfo = "No Meal",
                boardingTime = "06:30 AM"
            ),
            Flight(
                airlineName = "Air India",
                airlineIconResId = R.drawable.ic_indigo,
                departureCode = "DEL",
                departureTime = "08:15",
                arrivalCode = "BLR",
                arrivalTime = "12:45",
                duration = "04h 30m",
                price = "7,999",
                mealInfo = "Free Meal",
                boardingTime = "07:45 AM"
            )
        )
    }
}