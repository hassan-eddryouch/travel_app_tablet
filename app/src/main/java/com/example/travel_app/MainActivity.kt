package com.example.travel_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerFlights: RecyclerView
    private lateinit var flightAdapter: FlightAdapter
    private val flightList = mutableListOf<Flight>()
    private val flightListFull = mutableListOf<Flight>()
    private var isDarkMode = false


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerFlights = findViewById(R.id.recyclerFlights)
        recyclerFlights.layoutManager = LinearLayoutManager(this)

        flightList.add(Flight("Air Maroc", "CAS", "06:30", "CDG", "10:45", "04h 15m", "€320", "Free Meal"))
        flightList.add(Flight("Iberia", "MAD", "09:00", "BCN", "10:30", "01h 30m", "€120", "Snack included"))
        flightList.add(Flight("TAP Portugal", "LIS", "07:45", "OPO", "08:45", "01h 00m", "€90", "Meal included"))
        flightList.add(Flight("Air Maroc", "CAS", "08:00", "PAR", "12:00", "04h 00m", "€310", "Free Meal"))

        flightListFull.addAll(flightList)

        flightAdapter = FlightAdapter(flightList)
        recyclerFlights.adapter = flightAdapter

        val btnLowToHigh: Button = findViewById(R.id.btnLowToHigh)
        val btnHighToLow: Button = findViewById(R.id.btnHighToLow)
        val btnAirlinesType: Button = findViewById(R.id.btnAirlinesType)
        val btnDarkMode: ImageView = findViewById(R.id.btnDarkMode)

        btnDarkMode.setOnClickListener {
            isDarkMode = !isDarkMode
            if (isDarkMode) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        btnLowToHigh.setOnClickListener {
            flightList.sortBy { it.price.replace("€", "").replace(",", "").toInt() }
            flightAdapter.notifyDataSetChanged()
        }

        btnHighToLow.setOnClickListener {
            flightList.sortByDescending { it.price.replace("€", "").replace(",", "").toInt() }
            flightAdapter.notifyDataSetChanged()
        }

        btnAirlinesType.setOnClickListener {
            val airlines = flightListFull.map { it.airlineName }.distinct().toTypedArray()
            AlertDialog.Builder(this)
                .setTitle("Select Airline")
                .setItems(airlines) { _, which ->
                    val selected = airlines[which]
                    flightList.clear()
                    flightList.addAll(flightListFull.filter { it.airlineName == selected })
                    flightAdapter.notifyDataSetChanged()
                }
                .setNegativeButton("All") { _, _ ->
                    flightList.clear()
                    flightList.addAll(flightListFull)
                    flightAdapter.notifyDataSetChanged()
                }.show()
        }
    }
}