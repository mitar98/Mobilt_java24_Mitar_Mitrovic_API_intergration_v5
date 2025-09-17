package com.example.weathernavapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weathernavapp.R
import com.example.weathernavapp.databinding.FragmentForecastListBinding
import com.example.weathernavapp.model.ForecastUi
import com.example.weathernavapp.vm.WeatherVm

class ForecastListFragment : Fragment() {
    private var _b: FragmentForecastListBinding? = null
    private val b get() = _b!!
    private val vm: WeatherVm by activityViewModels()
    private lateinit var adapter: ForecastAdapter

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, s: Bundle?): View {
        _b = FragmentForecastListBinding.inflate(i, c, false)
        return b.root
    }

    override fun onViewCreated(v: View, s: Bundle?) {
        adapter = ForecastAdapter { ui: ForecastUi ->
            val bundle = Bundle().apply { putParcelable("item", ui) }
            findNavController().navigate(R.id.action_list_to_detail, bundle)
        }
        b.rvForecast.layoutManager = LinearLayoutManager(requireContext())
        b.rvForecast.adapter = adapter

        vm.forecast.observe(viewLifecycleOwner) { items ->
            adapter.submit(items.map { it.toUi() })
        }
        if (vm.forecast.value.isNullOrEmpty()) vm.refresh()
    }

    override fun onDestroyView() { _b = null; super.onDestroyView() }
}