package com.example.plantai2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plantai2.data.Plant
import com.example.plantai2.data.PlantAdapter
import com.example.plantai2.databinding.FragmentPlantListBinding
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PlantListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlantListFragment : Fragment() {
    private lateinit var plantAdapter: PlantAdapter
    private val sharedViewModel: SharedViewModel by activityViewModels()

    private var _binding: FragmentPlantListBinding? = null
    private val binding get() = _binding!!


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlantListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        plantAdapter = PlantAdapter { selectedPlant ->
            // Handle item click, for example:
            sharedViewModel.selectPlant(selectedPlant)
            findNavController().navigate(R.id.action_plantListFragment_to_plantDetailFragment)
        }
        binding.plantRecyclerView.apply {
            adapter = plantAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                val newPlant = Plant(
                    strainType = "Indica",
                    strainSource = "Seedbank",
                    plantAge = "2 months",
                    humidityLevel = "60%",
                    temperatureLevel = "22°C",
                    lightExposure = "Full Sun",
                    soilType = "Loamy",
                    pHLevels = "6.5",
                    wateringSchedule = "Every 3 days",
                    nutrientBrand = "BrandX",
                    nutrientFrequency = "Once a week",
                    plantHeight = "30cm",
                    leafCondition = "Healthy",
                    pestSigns = "None",
                    desiredYield = "200g",
                    preferredHarvestTime = "October",
                    previousGrowthCycles = "1",
                    methodChanges = "None"
                )

                // Insert the plant into the database
                sharedViewModel.addPlant(newPlant)

                sharedViewModel.plantList.collect { plants ->
                    plantAdapter.submitList(plants)
                }
            }


        }


    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PlantListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlantListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}