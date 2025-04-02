// PlantDetailFragment.kt
package com.example.plantai2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plantai2.databinding.FragmentPlantDetailBinding

class PlantDetailFragment : Fragment() {

    private var _binding: FragmentPlantDetailBinding? = null
    private val binding get() = _binding!!
   // private val args: PlantDetailFragmentArgs by navArgs()
    private var plantId: Long = -1 // Initialize with a default value

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlantDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // plantId = args.plantId
        // TODO: Load plant details based on plantId and display them
        binding.textViewPlantName.text = "Plant ID: $plantId" // Placeholder

        // TODO: Load and display growth data in the RecyclerView
        binding.growthDataRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        // binding.growthDataRecyclerView.adapter = GrowthDataAdapter(...)

        // TODO: Implement logic to generate and display recommendations
        binding.textViewRecommendations.text = "Loading recommendations..."

        binding.fabLogGrowth.setOnClickListener {
         //   val action = PlantDetailFragmentDirections.actionPlantDetailFragmentToGrowthLogFragment(plantId)
           // findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}