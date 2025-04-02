// PlantListFragment.kt
package com.example.plantai2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plantai2.databinding.FragmentPlantListBinding

class PlantListFragment : Fragment() {

    private var _binding: FragmentPlantListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlantListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabAddPlant.setOnClickListener {
            findNavController().navigate(R.id.action_plantListFragment_to_addPlantFragment)
        }

        // TODO: Implement RecyclerView adapter and data loading
        binding.plantRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        // binding.plantRecyclerView.adapter = PlantAdapter(...)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}