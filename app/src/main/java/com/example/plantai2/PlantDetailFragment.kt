package com.example.plantai2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import com.example.plantai2.databinding.FragmentPlantDetailBinding

class PlantDetailFragment : Fragment(R.layout.fragment_plant_detail) {

    private var _binding: FragmentPlantDetailBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlantDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Collect the selected plant flow
        viewLifecycleOwner.lifecycleScope.launch {
            sharedViewModel.selectedPlant.collect { plant ->
                // Ensure the plant is not null before updating the UI
                plant?.let {
                    binding.textViewPlantName.text = "Plant Name: ${it.strainType}"
                    binding.textViewStrainType.text = "Strain Type: ${it.strainType}"
                    binding.textViewStrainSource.text = "Strain Source: ${it.strainSource}"
                    binding.textViewAge.text = "Plant Age: ${it.plantAge}"
                    binding.textViewHumidityLevel.text = "Humidity Level: ${it.humidityLevel}"
                    binding.textViewTemperatureLevel.text = "Temperature Level: ${it.temperatureLevel}"
                    binding.textViewLightExposure.text = "Light Exposure: ${it.lightExposure}"
                    binding.textViewSoilType.text = "Soil Type: ${it.soilType}"
                    binding.textViewNutrientBrand.text = "Nutrient Brand: ${it.nutrientBrand}"
                    binding.textViewNutrientFrequency.text = "Nutrient Frequency: ${it.nutrientFrequency}"
                    binding.textViewPHLevels.text = "pH Levels: ${it.pHLevels}"
                    binding.textViewWateringSchedule.text = "Watering Schedule: ${it.wateringSchedule}"
                    binding.textViewLeafCondition.text = "Leaf Condition: ${it.leafCondition}"
                    binding.textViewPestSigns.text = "Pest Signs: ${it.pestSigns}"
                    binding.textViewDesiredYield.text = "Desired Yield: ${it.desiredYield}"
                    binding.textViewPreferredHarvestTime.text = "Preferred Harvest Time: ${it.preferredHarvestTime}"
                    binding.textViewPreviousGrowthCycles.text = "Previous Growth Cycles: ${it.previousGrowthCycles}"
                    binding.textViewMethodChanges.text = "Method Changes: ${it.methodChanges}"
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
