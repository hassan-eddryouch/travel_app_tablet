package com.example.travel_app

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.travel_app.databinding.DetailsCardBinding

class FlightDetailFragment : Fragment() {

    private var _binding: DetailsCardBinding? = null
    private val binding get() = _binding!!

    private var flight: Flight? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            flight = it.getParcelableCompat(ARG_FLIGHT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailsCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        flight?.let {
            binding.detailAirlineName?.text = it.airlineName
            binding.detailDepartureCode?.text = it.departureCode
            binding.detailArrivalCode?.text = it.arrivalCode
            binding.detailDuration?.text = it.duration
            binding.detailMealStatus?.text = it.mealInfo
            binding.detailBoardingTime?.text = it.boardingTime
        }

        binding.btnBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_FLIGHT = "flight_data"

        @JvmStatic
        fun newInstance(flight: Flight) =
            FlightDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_FLIGHT, flight)
                }
            }
    }
}
inline fun <reified T : Parcelable> Bundle.getParcelableCompat(key: String): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // API 33+
        getParcelable(key, T::class.java)
    } else {
        @Suppress("DEPRECATION")
        getParcelable(key) as? T // L'ancien appel
    }
}